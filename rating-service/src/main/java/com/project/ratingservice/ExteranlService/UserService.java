package com.project.ratingservice.ExteranlService;


import com.project.ratingservice.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface UserService {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable String id);
}
