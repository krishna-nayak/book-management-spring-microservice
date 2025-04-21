package com.project.ratingservice.Controller;


import com.project.ratingservice.ExteranlService.UserService;
import com.project.ratingservice.Model.Rating;
import com.project.ratingservice.Services.RatingService;
import com.project.ratingservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
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
