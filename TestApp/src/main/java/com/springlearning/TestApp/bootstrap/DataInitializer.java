
package com.springlearning.TestApp.bootstrap;

import com.springlearning.TestApp.model.Author;
import com.springlearning.TestApp.model.Book;
import com.springlearning.TestApp.model.Publisher;
import com.springlearning.TestApp.repositories.AuthorRepository;
import com.springlearning.TestApp.repositories.BookRepository;
import com.springlearning.TestApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {


    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher= new Publisher("Pearson Education","8100 Long Avenue","Albuquerque","New Mexico","54321");

        publisherRepository.save(publisher);


        Author author = new Author("John","Thompson");
        Book book = new Book("Head First Java","ISBN1234354");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        publisher.getBooks().add(book);
        book.setPublisher(publisher);

        authorRepository.save(author);
        bookRepository.save(book);


        System.out.println("Authors Count:"+authorRepository.count());
        System.out.println("Book Count:"+bookRepository.count());
        System.out.println("Publisher Count:"+publisherRepository.count());

        System.out.println("Publisher Book Count:"+publisher.getBooks().size());
    }
}
