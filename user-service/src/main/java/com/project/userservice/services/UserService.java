package com.project.userservice.services;

import com.project.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();
    User getUserById(String id);

//    TODO: UPDATE
//    TODO: DELETE
}
