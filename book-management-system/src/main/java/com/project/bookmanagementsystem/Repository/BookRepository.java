package com.project.bookmanagementsystem.Repository;

import com.project.bookmanagementsystem.Model.BookItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookItem, String> {

}
