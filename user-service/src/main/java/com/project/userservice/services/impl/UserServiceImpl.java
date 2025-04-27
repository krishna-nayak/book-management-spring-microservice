package com.project.userservice.services.impl;

import com.project.userservice.dto.Book;
import com.project.userservice.dto.Rating;
import com.project.userservice.exceptions.ResourceNotFoundException;
import com.project.userservice.extranal.services.BookServices;
import com.project.userservice.extranal.services.RatingService;
import com.project.userservice.model.User;
import com.project.userservice.repositories.UserRepository;
import com.project.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookServices bookService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with the given id is not found on server: " + id));
//      Getting user rating through Rating microservices
//      {{rating_url}}/ratings/user/:userId
            List<Rating> ratingOfUser = ratingService.getRatingByUserID(id);
            List<Rating> ratingStream = ratingOfUser.stream().map(rating -> {
                Book book = bookService.getBookId(rating.getBookId());
                rating.setBook(book);
                return rating;
            }).collect(Collectors.toList());

            user.setRating(ratingStream);
            return user;
    }


}
