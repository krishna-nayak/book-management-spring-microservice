package com.project.ratingservice.services.impl;

import com.project.ratingservice.model.Rating;
import com.project.ratingservice.Repository.RatingRepository;
import com.project.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }
    @Override
    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }
    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }
    @Override
    public List<Rating> getRatingByBookId(String bookId) {
        return ratingRepository.findByBookId(bookId);
    }
}