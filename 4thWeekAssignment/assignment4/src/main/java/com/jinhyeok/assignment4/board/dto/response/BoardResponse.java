package com.jinhyeok.assignment4.board.dto.response;

import com.jinhyeok.assignment4.board.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardResponse(
        @NotNull
        @Schema(description = "보드 ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "보드 제목", example = "제목입니다")
        String title,
        @Schema(description = "보드 내용", example = "내용입니다")
        String content,
        @NotNull
        @Schema(description = "보드 생성 시간", example = "2024-10-10 10:10:00")
        LocalDateTime createdAt,
        @NotNull
        @Schema(description = "보드 수정 시간", example = "2024-10-13 10:10:00")
        LocalDateTime updatedAt) {
    public static BoardResponse of(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}

