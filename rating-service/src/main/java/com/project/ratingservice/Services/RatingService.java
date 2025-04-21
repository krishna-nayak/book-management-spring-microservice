package com.project.ratingservice.Services;

import com.project.ratingservice.Model.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);
    List<Rating> getRating();
    List<Rating> getRatingByUserId(String user_id);
    List<Rating> getRatingByBookId(String book_id);
}
