package com.project.userservice.extranal.services;

import com.project.userservice.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/user/{id}")
    List<Rating> getRatingByUserID(@PathVariable("id") String id);

}
