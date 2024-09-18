package com.askify.services;

import com.askify.dto.request.PostCreateRequest;
import com.askify.dto.request.PostUpdateRequest;
import com.askify.entities.Post;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    List<Post> getAllPosts(Optional<Log> userId);

    Post getOnePostById(Long postId);

    Post saveOnePost(PostCreateRequest postRequest);

    Post updateOnePost(PostUpdateRequest postUpdateRequest);

    void deleteOnePost(Long id);
}
