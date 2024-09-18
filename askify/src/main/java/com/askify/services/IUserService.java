package com.askify.services;

import com.askify.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User saveOneUser(User user);

    User getOneUserById(Long userID);

    User updateOneUser(User user);

    void deleteOneUser(Long userID);
}
