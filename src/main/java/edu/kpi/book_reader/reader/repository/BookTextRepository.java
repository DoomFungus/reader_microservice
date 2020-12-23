package edu.kpi.book_reader.reader.repository;

import edu.kpi.book_reader.reader.model.BookText;
import org.springframework.data.repository.CrudRepository;

public interface BookTextRepository extends CrudRepository<BookText, Integer> {
}
