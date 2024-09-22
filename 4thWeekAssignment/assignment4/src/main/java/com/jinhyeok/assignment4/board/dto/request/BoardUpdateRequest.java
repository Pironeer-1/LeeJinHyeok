package com.jinhyeok.assignment4.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateRequest(
        @NotNull
        @Schema(description = "Board의 ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "Board의 제목", example = "Board title")
        String title,
        @Schema(description = "Board의 내용", example = "I am a board.")
        String content
) {
}