package com.askify.dto.request;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private Long id;
    private String text;
}
