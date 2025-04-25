package com.project.ratingservice.services.impl;

import com.project.ratingservice.model.Rating;
import com.project.ratingservice.Repository.RatingRepository;
import com.project.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }
    @Override
    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }
    @Override
    public List<Rating> getRatingByUserId(String user_id) {
        return ratingRepository.findByUserId(user_id);
    }
    @Override
    public List<Rating> getRatingByBookId(String book_id) {
        return ratingRepository.findByBookId(book_id);
    }
}