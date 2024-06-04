package com.example.foodtrucks.repository;

import com.example.foodtrucks.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookRepositoryTest {
    @Mock
    BookRepository bookRepository;

    @Test
    public void BookRepository_GetAllReturnsAllBooks() {
        // Arrange
        List<Book> expectedBooks = Arrays.asList(
                new Book(1L, "Book 1", "Author 1"),
                new Book(2L, "Book 2", "Author 2"),
                new Book(3L, "Book 2", "Author 2")
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookRepository.findAll();
        System.out.println(
                actualBooks.size()
        );

        // Assert
        assertEquals(expectedBooks.size(), actualBooks.size());
        assertEquals(expectedBooks, actualBooks);
        verify(bookRepository, times(1)).findAll();
    }
}
