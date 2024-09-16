package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.ComComment;
import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public record ComCommentResponse(Long id, Long commentId, String content, LocalDateTime updatedAt) {
    public static ComCommentResponse of (ComComment comComment) {
        return new ComCommentResponse(comComment.getId(), comComment.getCommentId(), comComment.getContent(), comComment.getUpdatedAt());
    }
}
