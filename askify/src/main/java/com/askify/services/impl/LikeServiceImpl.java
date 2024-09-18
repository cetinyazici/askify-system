package com.askify.services.impl;

import com.askify.dto.request.LikeCreateRequest;
import com.askify.entities.Comment;
import com.askify.entities.Like;
import com.askify.entities.Post;
import com.askify.entities.User;
import com.askify.repository.LikeRepository;
import com.askify.services.ILikeService;
import com.askify.services.IPostService;
import com.askify.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements ILikeService {

    @Autowired
    private LikeRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @Override
    public List<Like> getAllLikeWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return repository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return repository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return repository.findByPostId(postId.get());
        } else
            return repository.findAll();
    }

    @Override
    public Like saveOneLike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if (user != null && post != null) {
            Like like = new Like();
            like.setId(request.getId());
            like.setUser(user);
            like.setPost(post);
            return repository.save(like);
        } else
            return null;
    }

    @Override
    public Like getOneLikeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteOneLike(Long id) {
        repository.deleteById(id);
    }
}
