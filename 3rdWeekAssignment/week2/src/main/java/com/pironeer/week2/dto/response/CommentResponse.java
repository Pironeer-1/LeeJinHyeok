package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id, Long topicId, String content, LocalDateTime updatedAt) {

    public static CommentResponse of (Comment comment) {
        return new CommentResponse(comment.getId(), comment.getTopicId(), comment.getContent(), comment.getUpdatedAt());
    }
}