package edu.kpi.book_reader.reader.service.impl;

import edu.kpi.book_reader.reader.model.BookText;
import edu.kpi.book_reader.reader.repository.BookTextRepository;
import edu.kpi.book_reader.reader.service.BookTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookTextServiceImpl implements BookTextService {
    BookTextRepository bookTextRepository;

    @Autowired
    public BookTextServiceImpl(BookTextRepository bookTextRepository) {
        this.bookTextRepository = bookTextRepository;
    }

    @Override
    public void createBookText(BookText bookText) throws IllegalArgumentException {
        if(bookTextRepository.existsById(bookText.getBookId()))
            throw new IllegalArgumentException("Text already exists");
        bookTextRepository.save(bookText);
    }

    @Override
    public Optional<BookText> findBookText(Integer bookId) {
        return bookTextRepository.findById(bookId);
    }
}
