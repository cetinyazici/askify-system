package com.askify.controller;

import com.askify.dto.request.PostCreateRequest;
import com.askify.dto.request.PostUpdateRequest;
import com.askify.entities.Post;
import com.askify.services.IPostService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/post")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private IPostService service;

    @PostMapping(path = "/save")
    public Post savePost(@RequestBody PostCreateRequest postRequest) {
        return service.saveOnePost(postRequest);
    }

    @GetMapping(path = "/list")
    public List<Post> getAllPosts(@RequestParam Optional<Log> userId) {
        return service.getAllPosts(userId);
    }

    @GetMapping(path = "/list/{id}")
    public Post getOnePost(@PathVariable(name = "id") Long postId) {
        return service.getOnePostById(postId);
    }

    @PutMapping(path = "/update")
    public Post updateOnePost(@RequestBody PostUpdateRequest post) {
        return service.updateOnePost(post);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOnePost(@PathVariable(name = "id") Long id) {
        service.deleteOnePost(id);
    }
}
