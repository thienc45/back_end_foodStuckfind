package com.example.foodtrucks.service;

import com.example.foodtrucks.contants.ConstantRedisKey;
import com.example.foodtrucks.entity.Book;
import com.example.foodtrucks.repository.BookRepository;
import com.example.foodtrucks.service.impl.BookServiceImpl;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})

public class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;

    @Mock
    private RedisTemplate redisTemplate;


    @InjectMocks
    private BookServiceImpl bookService;

    private List<Book> createMockBooks() {
        return Arrays.asList(
                new Book(1L, "Book 1", "Author 1"),
                new Book(2L, "Book 2", "Author 2")
        );
    }

    @Test
    public void testGetAllBooksFromDatabaseWhenRedisIsNull() {
        // Arrange
        List<Book> mockBooks = createMockBooks();
        ListOperations<String, Book> listOperationsMock = mock(ListOperations.class);
        when(redisTemplate.opsForList()).thenReturn(listOperationsMock); // Mocking opsForList()
        when(listOperationsMock.rightPushAll(ConstantRedisKey.KEY_BOOK_ALL, any(), any())).thenReturn(null); // Mocking range() method
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // Act
        List<Book> actualBooks = bookService.getAllBooks();

        // Assert
        assertEquals(mockBooks.size(), actualBooks.size());
        assertEquals(mockBooks, actualBooks);
        verify(bookRepository, times(1)).findAll(); // Ensure findAll() is called once
        verify(listOperationsMock, times(1)).rightPushAll(anyString(), (Book) eq(mockBooks), any(Book.class)); // Ensure Redis cache is populated once
    }


}
