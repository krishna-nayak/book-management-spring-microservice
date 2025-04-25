package com.project.ratingservice.dto;

public record RatingDto(
        String userId,
        String bookId,
        int rating,
        String feedback
) {}
