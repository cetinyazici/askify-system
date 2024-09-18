package com.askify.services;

import com.askify.dto.request.CommentCreateRequest;
import com.askify.dto.request.CommentUpdateRequest;
import com.askify.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {

    List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment saveOneComment(CommentCreateRequest request);

    Comment getOneCommnetById(Long id);

    Comment updateOneComment(CommentUpdateRequest request);

    void deleteOneCommnet(Long id);
}
