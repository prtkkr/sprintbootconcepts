package com.demo.springbootconcepts.repositories;

import com.demo.springbootconcepts.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
