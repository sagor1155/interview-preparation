package org.example.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;
    @Mock
    BookRepository repository;
    @Mock
    Iterator<String> i;
    Comparable<String> c;

    @Test
    void testInitialization() {
        assertNotNull(bookService);
        assertNotNull(repository);
    }

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

    // demonstrates the return of multiple values
    @Test
    void testMoreThanOneReturnValue() {
        Mockito.when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        // assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
    // and that @Mock can also be used for a method parameter
    @Test
    void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c)  {
        Mockito.when(c.compareTo("Mockito")).thenReturn(1);
        Mockito.when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

}
