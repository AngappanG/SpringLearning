package com.springlearning.TestApp.repositories;

import com.springlearning.TestApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
