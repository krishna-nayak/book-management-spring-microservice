package com.project.bookmanagementsystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
@Data
public class BookItem {
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
