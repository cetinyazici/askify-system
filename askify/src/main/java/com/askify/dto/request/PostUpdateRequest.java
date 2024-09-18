package com.askify.dto.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private Long id;
    private String title;
    private String content;
}
