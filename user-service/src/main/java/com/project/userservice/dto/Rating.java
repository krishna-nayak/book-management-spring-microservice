package com.project.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {


    private String ratingId;
    private String userId;
    private String bookId;
    private int rating;
    private String feedback;
    private Book book;
}
