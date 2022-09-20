package com.project.dao;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.entity.Author;
import com.project.entity.Book;
import com.project.entity.Publisher;
import com.project.repositories.AuthorRepository;
import com.project.repositories.BookRepository;
import com.project.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
    private final AuthorRepository authorRepository;
 
    private final BookRepository bookRepository;
    
    private final PublisherRepository publisherRepository;
   
    
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Publisher publisher = new Publisher();
	    publisher.setName("SFG Publishing");
	    publisher.setAddressLine1("Ansal");
	    publisher.setCity("Gurgaon");
	    publisher.setState("Haryana");
	    publisher.setZip(122102);
	    publisherRepository.save(publisher);
	    
		Author author=new Author("Divya","Bansal");
		Book book=new Book("Spring Tools","1223");
		author.getBooks().add(book);
		book.getAuthors().add(author);
		book.setPublisher(publisher);
		publisher.getBooks().add(book);
		authorRepository.save(author);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		Author author1=new Author("Sanjana","Agarwal");
		Book book1=new Book("Spring Boot","12234");
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		book1.setPublisher(publisher);
		publisher.getBooks().add(book1);
		authorRepository.save(author1);
		bookRepository.save(book1);
		publisherRepository.save(publisher);
		

	    System.out.println("Publisher Count: " + publisherRepository.count());
	    System.out.println("Publisher number of Books: "+publisher.getBooks().size());
		System.out.println("Started DAO");
		System.out.println("Number of Books: "+bookRepository.count());
		System.out.println("Number of Authors: "+authorRepository.count());
	}

}
