package com.example.BookApplication.Services;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> addBulkBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setGenre(book.getGenre());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public ResponseEntity<List<Book>> getBooksByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.findByAuthor(author));
    }

    public ResponseEntity<List<Book>> getBooksByTitle(String title) {
        return ResponseEntity.ok(bookRepository.findByTitle(title));
    }

    public ResponseEntity<Book> getBookByGenre(String genre) {
        return ResponseEntity.ok(bookRepository.findByGenre(genre));
    }
}