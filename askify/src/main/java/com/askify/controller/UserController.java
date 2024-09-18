package com.askify.controller;

import com.askify.entities.User;
import com.askify.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping(path = "/save")
    public User saveOneUser(@RequestBody User user) {
        return service.saveOneUser(user);
    }

    @GetMapping(path = "/list")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(path = "/list/{id}")
    public User getOneuser(@PathVariable(name = "id") Long id) {
        return service.getOneUserById(id);
    }

    @PutMapping(path = "/update")
    public User updateOneUser(@RequestBody User user) {
        return service.updateOneUser(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOneUser(@PathVariable(name = "id") Long id) {
        service.deleteOneUser(id);
    }
}
