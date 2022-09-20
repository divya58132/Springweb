package com.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
}
