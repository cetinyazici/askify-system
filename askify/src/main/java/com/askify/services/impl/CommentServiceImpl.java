package com.askify.services.impl;

import com.askify.dto.request.CommentCreateRequest;
import com.askify.dto.request.CommentUpdateRequest;
import com.askify.entities.Comment;
import com.askify.entities.Post;
import com.askify.entities.User;
import com.askify.repository.CommentRepository;
import com.askify.services.ICommentService;
import com.askify.services.IPostService;
import com.askify.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @Override
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
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
    public Comment saveOneComment(CommentCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if (user != null && post != null) {
            Comment comment = new Comment();
            comment.setId(request.getId());
            comment.setUser(user);
            comment.setPost(post);
            comment.setText(request.getText());
            return repository.save(comment);
        } else
            return null;
    }

    @Override
    public Comment getOneCommnetById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Comment updateOneComment(CommentUpdateRequest request) {
        Optional<Comment> optional = repository.findById(request.getId());
        if (optional.isPresent()) {
            Comment comment = optional.get();
            comment.setText(request.getText());
            return repository.save(comment);
        }
        return null;
    }

    @Override
    public void deleteOneCommnet(Long id) {
        repository.deleteById(id);
    }
}
