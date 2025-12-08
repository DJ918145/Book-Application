package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import com.example.BookApplication.Services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        final Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }
}
