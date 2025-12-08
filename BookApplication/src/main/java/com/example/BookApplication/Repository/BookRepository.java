package com.example.BookApplication.Repository;

import com.example.BookApplication.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.jar.JarInputStream;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
