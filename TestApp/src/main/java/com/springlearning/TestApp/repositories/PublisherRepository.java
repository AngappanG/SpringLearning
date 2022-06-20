package com.springlearning.TestApp.repositories;

import com.springlearning.TestApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
