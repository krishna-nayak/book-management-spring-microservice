package com.project.bookmanagementsystem.repository;

import com.project.bookmanagementsystem.model.BookItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookItem, String> {

}
