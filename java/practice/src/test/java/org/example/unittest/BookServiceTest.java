package org.example.unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository repository;

    @Test
    void testBookFind() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(new Book(1, "7andHalf")));
        assertEquals(1,  bookService.findBook(1).id);
    }

    @Test
    void testBookFindException() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.ofNullable(null));
        RuntimeException ex = assertThrows(RuntimeException.class,  () -> bookService.findBook(1));
        assertEquals(ex.getMessage(), "Book not found!");
    }

}
