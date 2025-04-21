package com.project.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private String id;

    private String book_id;

    private String title;
    private String genre;
    private String publication_date;
    private String author;
    private double rating;
    private String isbn;
    private String language;
    private int copies;
    private float price;
    public int available_copies;

    public String publisher;
    private String description;
}
