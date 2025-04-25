package com.project.ratingservice.controller;

import com.project.ratingservice.ExteranlService.UserService;
import com.project.ratingservice.model.Rating;
import com.project.ratingservice.services.RatingService;
import com.project.ratingservice.dto.RatingDto;
import com.project.ratingservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final UserService userService;

    @Autowired
    public RatingController(RatingService ratingService, UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Rating> create(@RequestBody RatingDto ratingDto) {
        Rating rating = new Rating();
        rating.setRating(ratingDto.rating());
        rating.setFeedback(ratingDto.feedback());
        rating.setBookId(ratingDto.bookId());
        rating.setUserId(ratingDto.userId());

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRating());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("id") String id){
        return ResponseEntity.ok(ratingService.getRatingByUserId(id));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<Rating>> getRatingsByBookId(@PathVariable("id") String id){
        return ResponseEntity.ok(ratingService.getRatingByBookId(id));
    }

//    FIXME: DELETE after testing
    @GetMapping("/user-details/{id}")
    public ResponseEntity<User> getUserID(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
