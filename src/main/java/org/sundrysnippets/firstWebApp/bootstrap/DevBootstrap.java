package org.sundrysnippets.firstWebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.sundrysnippets.firstWebApp.model.Author;
import org.sundrysnippets.firstWebApp.model.Book;
import org.sundrysnippets.firstWebApp.model.Publisher;
import org.sundrysnippets.firstWebApp.repositories.AuthorRepository;
import org.sundrysnippets.firstWebApp.repositories.BookRepository;
import org.sundrysnippets.firstWebApp.repositories.PublisherRepository;

import java.util.ArrayList;

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

        Publisher crazy = new Publisher("Crazy Publisher", "Crazy town, CR");
        Publisher notSoCrazy = new Publisher("Not So Crazy Publisher", "No Crazy town, NC");
        Publisher newPublisher = new Publisher("New Publisher", "New town, NT");
        ArrayList<Publisher> list = new ArrayList();
        list.add(crazy); list.add(notSoCrazy); list.add(newPublisher);
        publisherRepository.saveAll(list);

        // First Record
        Author eric = new Author("Eric", "Evans");
        // authorRepository.save(eric);

        Book thisBook = new Book("Eric's First Book","123",crazy);
        eric.getBooks().add(thisBook);
        thisBook.getAuthors().add(eric);
        bookRepository.save(thisBook);

        // Second Record
        Author johnny = new Author("Johnny", "Walker");
        // authorRepository.save(johnny);

        Book coAuthored = new Book("Crazy Book to Read","456",notSoCrazy);
        eric.getBooks().add(coAuthored);
        johnny.getBooks().add(coAuthored);
        coAuthored.getAuthors().add(eric);
        coAuthored.getAuthors().add(johnny);
        bookRepository.save(coAuthored);

        // Third Record
        Book thatBook = new Book("Johnny's Book", "789", newPublisher);
        thatBook.getAuthors().add(johnny);
        johnny.getBooks().add(thatBook);

        bookRepository.save(thatBook);


        // Fourth Record
        Book oneMoreBook = new Book("Fourth Book", "999", newPublisher);
        oneMoreBook.getAuthors().add(johnny);
        johnny.getBooks().add(oneMoreBook);

        bookRepository.save(oneMoreBook);

        authorRepository.save(johnny);
        authorRepository.save(eric);
    }
}
