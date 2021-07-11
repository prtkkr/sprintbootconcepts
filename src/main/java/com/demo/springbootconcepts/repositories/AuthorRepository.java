package com.demo.springbootconcepts.repositories;

import com.demo.springbootconcepts.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
