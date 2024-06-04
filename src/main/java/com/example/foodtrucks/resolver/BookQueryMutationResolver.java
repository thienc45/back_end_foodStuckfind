package com.example.foodtrucks.resolver;

import com.example.foodtrucks.entity.Book;
import com.example.foodtrucks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BookQueryMutationResolver {
    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }


    @MutationMapping
    public Book createBook(@Argument String title,@Argument String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument String title,@Argument String author) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            return bookRepository.save(book);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
