package com.askify.services;

import com.askify.dto.request.CommentCreateRequest;
import com.askify.dto.request.CommentUpdateRequest;
import com.askify.dto.request.LikeCreateRequest;
import com.askify.entities.Comment;
import com.askify.entities.Like;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<Like> getAllLikeWithParam(Optional<Long> userId, Optional<Long> postId);

    Like saveOneLike(LikeCreateRequest request);

    Like getOneLikeById(Long id);

    void deleteOneLike(Long id);
}
