package com.moon0.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String Content,
        String hashtag
) implements Serializable {
    public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String Content, String hashtag) {
        return new ArticleDto(createdAt, createdBy, title, Content, hashtag);
    }
}
