package edu.kpi.book_reader.reader.controller;

import edu.kpi.book_reader.reader.model.BookText;
import edu.kpi.book_reader.reader.service.BookTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/book_text")
public class BookTextController {
    BookTextService bookTextService;

    @Autowired
    public BookTextController(BookTextService bookTextService) {
        this.bookTextService = bookTextService;
    }

    @PostMapping
    public void saveBookText(@RequestBody String bookText, @RequestParam("book_id") Integer bookId){
        try {
            bookTextService.createBookText(new BookText(bookId, bookText));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to save book text");
        }
    }

    @GetMapping("/{book_id}")
    public String findBook(@PathVariable("book_id") Integer id){
        return bookTextService
                .findBookText(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find book"))
                .getText();
    }
}
