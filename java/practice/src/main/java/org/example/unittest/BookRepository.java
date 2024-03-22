package org.example.unittest;

import java.util.Optional;

public class BookRepository {
    Optional<Book> findById(Integer id) {
        return Optional.of(new Book(id, "dummy"));
    }
}
