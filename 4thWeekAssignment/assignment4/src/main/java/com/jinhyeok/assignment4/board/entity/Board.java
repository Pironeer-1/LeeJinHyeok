package com.jinhyeok.assignment4.board.entity;

import com.jinhyeok.assignment4.board.dto.request.BoardUpdateRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Board(
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Board update(BoardUpdateRequest boardUpdateRequest) {
        this.title = boardUpdateRequest.title();
        this.content = boardUpdateRequest.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
