package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import com.example.BookApplication.Services.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PostMapping("/addbulk")
    public ResponseEntity<List<Book>> addBulkBooks(@RequestBody List<Book> books){
        final List<Book> savedBooks = bookService.addBulkBooks(books);
        return ResponseEntity.ok(savedBooks);
    }

    @GetMapping("/getbook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        final Book book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatebook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        final Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getbooksbyauthor/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author){
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/getbooksbytitle/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/getbookbygenre/{genre}")
    public ResponseEntity<Book> getBookByGenre(@PathVariable String genre){
        return bookService.getBookByGenre(genre);
    }
}
