package com.project.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("rating")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String bookId;
    private int rate;
    private String feedback;

}
