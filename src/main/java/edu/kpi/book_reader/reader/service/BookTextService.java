package edu.kpi.book_reader.reader.service;

import edu.kpi.book_reader.reader.model.BookText;

import java.util.Optional;

public interface BookTextService {
    void createBookText(BookText bookText) throws IllegalArgumentException;

    Optional<BookText> findBookText(Integer bookId);
}
