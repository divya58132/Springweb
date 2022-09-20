package com.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
