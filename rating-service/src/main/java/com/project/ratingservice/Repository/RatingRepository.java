package com.project.ratingservice.Repository;

import com.project.ratingservice.Model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String id);
    List<Rating> findByBookId(String id);
}
