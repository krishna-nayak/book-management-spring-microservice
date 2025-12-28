package com.project.bookmanagementsystem.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record BookRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Genre is required")
        String genre,

        @NotBlank(message = "Publication date is required")
        String publicationDate,

        @NotBlank(message = "Author is required")
        String author,

        @DecimalMin(value = "0.0", message = "Rating must be at least 0")
        @DecimalMax(value = "5.0", message = "Rating must be at most 5")
        Double rating,

        @NotBlank(message = "ISBN is required")
        @Pattern(regexp = "^[0-9-]{10,}$", message = "Invalid ISBN format")
        String isbn,

        String language,

        @Min(value = 1, message = "Copies must be at least 1")
        Integer copies,

        @DecimalMin(value = "0.0", message = "Price must be positive")
        @Digits(integer = 5, fraction = 2, message = "Price must have at most 5 digits and 2 decimals")
        BigDecimal price,

        String publisher,

        String description
) { }