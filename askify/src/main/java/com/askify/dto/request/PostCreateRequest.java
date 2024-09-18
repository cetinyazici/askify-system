package com.askify.dto.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    private Long id;
    private Long userId;
    private String title;
    private String content;
}

