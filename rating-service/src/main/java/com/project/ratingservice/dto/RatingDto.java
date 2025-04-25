package com.project.ratingservice.dto;

public record RatingDto(
        String userId,
        String bookId,
        int rate,
        String feedback
) {}
