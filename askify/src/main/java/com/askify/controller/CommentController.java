package com.askify.controller;

import com.askify.dto.request.CommentCreateRequest;
import com.askify.dto.request.CommentUpdateRequest;
import com.askify.entities.Comment;
import com.askify.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @PostMapping(path = "/save")
    public Comment saveOneComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return service.saveOneComment(commentCreateRequest);
    }

    @GetMapping(path = "/list")
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId) {
        return service.getAllCommentsWithParam(userId, postId);
    }

    @GetMapping(path = "/list/{id}")
    public Comment getOneCommnetById(@PathVariable(name = "id") Long id) {
        return service.getOneCommnetById(id);
    }

    @PutMapping(path = "/update")
    public Comment updateOneComment(@RequestBody CommentUpdateRequest request) {
        return service.updateOneComment(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOneCommnet(@PathVariable(name = "id") Long id) {
        service.deleteOneCommnet(id);
    }
}
