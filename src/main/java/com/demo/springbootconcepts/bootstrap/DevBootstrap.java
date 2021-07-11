package com.demo.springbootconcepts.bootstrap;

import com.demo.springbootconcepts.model.Author;
import com.demo.springbootconcepts.model.Book;
import com.demo.springbootconcepts.model.Publisher;
import com.demo.springbootconcepts.repositories.AuthorRepository;
import com.demo.springbootconcepts.repositories.BookRepository;
import com.demo.springbootconcepts.repositories.PublisherRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Worx");
        publisherRepository.save(publisher);

        //eric
        Author eric = new Author("Eric", "Evan");
        Book dd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(dd);
        dd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(dd);

        //rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1235", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
