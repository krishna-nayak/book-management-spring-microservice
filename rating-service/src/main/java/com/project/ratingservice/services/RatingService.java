package com.project.ratingservice.services;

import com.project.ratingservice.model.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);
    List<Rating> getRating();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByBookId(String bookId);
}
