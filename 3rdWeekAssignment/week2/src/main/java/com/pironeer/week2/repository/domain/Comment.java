package com.pironeer.week2.repository.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    private Long id;
    private Long topicId; // Topic의 id와 연관되는 필드
    private String content;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long id, Long topicId, String content, LocalDateTime updatedAt) {
        this.id = id;
        this.topicId = topicId;
        this.content = content;
        this.updatedAt = updatedAt;
    }
}
