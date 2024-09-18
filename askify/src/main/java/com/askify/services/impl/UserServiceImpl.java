package com.askify.services.impl;

import com.askify.entities.User;
import com.askify.repository.UserRepository;
import com.askify.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User saveOneUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getOneUserById(Long userID) {
        Optional<User> optional = repository.findById(userID);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public User updateOneUser(User user) {
        Optional<User> optional = repository.findById(user.getId());
        if (optional.isPresent()) {
            User newUser = optional.get();

            newUser.setUserName(user.getUserName());
            newUser.setPassword(user.getPassword());
            return repository.save(newUser);
        }
        return null;
    }

    @Override
    public void deleteOneUser(Long userID) {
        User user = getOneUserById(userID);
        if (user != null) {
            repository.delete(user);
        }
    }
}
