package com.example.foodtrucks.service.impl;

import com.example.foodtrucks.contants.ConstantRedisKey;
import com.example.foodtrucks.entity.Book;
import com.example.foodtrucks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Book> getAllBooks() {
        List<Object> bookObjects = redisTemplate.opsForList().range(ConstantRedisKey.KEY_BOOK_ALL, 0, -1);
        if (bookObjects != null && !bookObjects.isEmpty()) {
            System.out.println("Retrieved books from Redis");
            return (List<Book>) (List<?>) bookObjects; // Cast to List<Book>
        } else {
            System.out.println("Fetching books from database");
            List<Book> books = bookRepository.findAll();
            if (!books.isEmpty()) {
                System.out.println("Caching books in Redis");
                redisTemplate.opsForList().rightPushAll(ConstantRedisKey.KEY_BOOK_ALL, books.toArray(), Duration.ofMinutes(1));
            }

            return books;
        }
    }

    public Optional<Book> getBookById(Long id) {

        // Kiểm tra xem sách có tồn tại trong Redis không
        Book bookFromRedis = (Book) redisTemplate.opsForValue().get(ConstantRedisKey.KEY_BOOK + id);
        if (bookFromRedis != null) {
            System.out.println("Retrieved book from Redis");
            return Optional.of(bookFromRedis);
        }

        // Nếu không tìm thấy trong Redis, thực hiện truy vấn cơ sở dữ liệu
        System.out.println("Fetching book from database by ID: " + id);
        Optional<Book> bookFromDatabase = bookRepository.findById(id);

        // Nếu sách tồn tại trong cơ sở dữ liệu, cache vào Redis
        bookFromDatabase.ifPresent(book -> redisTemplate.opsForValue().set(ConstantRedisKey.KEY_BOOK + id, book, Duration.ofMinutes(1)));

        //Thay thế cho đoạn lamda trên
        //        Optional<Book> bookOptional = bookFromDatabase;
        //        if (bookOptional.isPresent()) {
        //            Book book = bookOptional.get();
        //            redisTemplate.opsForValue().set(ConstantRedisBook.KEY_BOOK + id, book);
        //        }

        return bookFromDatabase;
    }

    public void updateBook(Book book) {
        bookRepository.save(book);

        // Sau khi cập nhật, cập nhật Redis (nếu cần)
        redisTemplate.opsForValue().set(ConstantRedisKey.KEY_BOOK + book.getId(), book);

        updateCacheAfterUpdate(book);
    }

    private void updateCacheAfterUpdate(Book book) {
        List<Book> allBooks = bookRepository.findAll();
        // Xóa cache cũ của danh sách tất cả cuốn sách
        // Kiểm tra xem cuốn sách có tồn tại trong cache không
        if (redisTemplate.hasKey(ConstantRedisKey.KEY_BOOK + book.getId())) {
            // Nếu cuốn sách tồn tại trong cache, cập nhật nó
            redisTemplate.opsForValue().set(ConstantRedisKey.KEY_BOOK + book.getId(), book);
            redisTemplate.delete(ConstantRedisKey.KEY_BOOK_ALL);
            // Thêm danh sách mới của tất cả cuốn sách vào cache
            redisTemplate.opsForList().rightPushAll(ConstantRedisKey.KEY_BOOK_ALL, allBooks.toArray());
        }

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

        // Sau khi xóa, xóa khỏi Redis (nếu cần)
        redisTemplate.delete(ConstantRedisKey.KEY_BOOK + id);
        updateCacheAfterDelete(id);
    }


    private void updateCacheAfterDelete(Long id) {
        List<Object> booksInCache = redisTemplate.opsForList().range(ConstantRedisKey.KEY_BOOK_ALL, 0, -1);
        if (booksInCache != null) {
            for (Object book : booksInCache) {
                // Kiểm tra xem cuốn sách có khóa id tương ứng không
                if (((Book) book).getId().equals(id)) {
                    // Nếu có, xóa nó khỏi danh sách trong cache
                    redisTemplate.opsForList().remove(ConstantRedisKey.KEY_BOOK_ALL, 0, book);
                    break;
                }
            }
        }
    }
}
