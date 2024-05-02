package com.example.foodtrucks.service.impl;

import com.example.foodtrucks.entity.Book;
import com.example.foodtrucks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable
    public List<Book> getAllBooks() {
        System.out.println("database");
        return bookRepository.findAll();
    }

    @Cacheable(key = "#id")
    public Optional<Book> getBookById(Long id) {
        System.out.println("getID database");
        return bookRepository.findById(id);
    }

    @CacheEvict(key = "#book.id",allEntries = true)
    public void saveBook(Book book) {
        System.out.println("add database");
        bookRepository.save(book);
    }

    @CacheEvict(key = "#book.id",allEntries = true,value = "updatecache")
    public void updateBook(Book book) {
        System.out.println("update database");
        bookRepository.save(book);
    }

    @CacheEvict(key ="#id",allEntries = true)
    public void deleteBook(Long id) {
        System.out.println("delete database");
        bookRepository.deleteById(id);
    }
}
