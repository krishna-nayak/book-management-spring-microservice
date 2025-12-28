package com.project.bookmanagementsystem.dto;

import java.math.BigDecimal;

/**
 * Response DTO for Book operations.
 * Contains only safe, client-visible fields.
 */
public record BookResponse(
        String id,
        String title,
        String author,
        String isbn,
        String genre,
        String publicationDate,
        Double rating,
        String language,
        Integer copies,
        Integer availableCopies,
        BigDecimal price,
        String publisher,
        String description,
        Long createdAt,
        Long updatedAt
) {
    // Immutable record — no setters, ensures data integrity
}