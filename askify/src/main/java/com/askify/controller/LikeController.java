package com.askify.controller;

import com.askify.dto.request.LikeCreateRequest;
import com.askify.entities.Like;
import com.askify.services.ILikeService;
import com.askify.services.impl.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/like")
public class LikeController {

    @Autowired
    private ILikeService service;

    @PostMapping(path = "/save")
    public Like saveOneLike(@RequestBody LikeCreateRequest request) {
        return service.saveOneLike(request);
    }

    @GetMapping(path = "/list")
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId,
                                  @RequestParam Optional<Long> postId) {
        return service.getAllLikeWithParam(userId, postId);
    }

    @GetMapping(path = "/list/{id}")
    public Like getOneLikeById(@PathVariable(name = "id") Long id) {
        return service.getOneLikeById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOneLike(@PathVariable(name = "id") Long id) {
        service.deleteOneLike(id);
    }
}
