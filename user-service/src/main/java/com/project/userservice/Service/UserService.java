package com.project.userservice.Service;

import com.project.userservice.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();
    User getUserById(String id);

//    TODO: UPDATE
//    TODO: DELETE
}
