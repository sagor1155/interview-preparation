package org.example.unittest;

import java.util.Optional;

public class BookService {

    BookRepository repository = new BookRepository();

    Book findBook(Integer id) {
        Optional<Book> book = repository.findById(id);
        if (book.isEmpty()) {
            throw new RuntimeException("Book not found!");
        } else {
            return book.get();
        }
    }
}
