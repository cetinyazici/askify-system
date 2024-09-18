package com.askify.services.impl;

import com.askify.dto.request.PostCreateRequest;
import com.askify.dto.request.PostUpdateRequest;
import com.askify.entities.Post;
import com.askify.entities.User;
import com.askify.repository.PostRepository;
import com.askify.services.IPostService;
import com.askify.services.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private IUserService userService;

    @Override
    public List<Post> getAllPosts(Optional<Log> userId) {
        if (userId.isPresent()) {
            return repository.findByUserId(userId);
        }
        return repository.findAll();
    }

    @Override
    public Post getOnePostById(Long postId) {
        return repository.findById(postId).orElse(null);
    }

    @Override
    public Post saveOnePost(PostCreateRequest postRequest) {
        User user = userService.getOneUserById(postRequest.getUserId());
        if (user == null)
            return null;
        Post savePost = new Post();
        savePost.setId(postRequest.getId());
        savePost.setTitle(postRequest.getTitle());
        savePost.setContent(postRequest.getContent());
        savePost.setUser(user);
        return repository.save(savePost);
    }

    @Override
    public Post updateOnePost(PostUpdateRequest postUpdateRequest) {
        Optional<Post> optional = repository.findById(postUpdateRequest.getId());
        if (optional.isPresent()) {
            Post post = optional.get();
            post.setId(postUpdateRequest.getId());
            post.setTitle(postUpdateRequest.getTitle());
            post.setContent(postUpdateRequest.getContent());

            return repository.save(post);
        }
        return null;
    }

    @Override
    public void deleteOnePost(Long id) {
        Post post = getOnePostById(id);
        if (post != null) {
            repository.delete(post);
        }
    }
}
