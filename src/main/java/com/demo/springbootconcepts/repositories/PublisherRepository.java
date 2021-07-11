package com.demo.springbootconcepts.repositories;

import com.demo.springbootconcepts.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
