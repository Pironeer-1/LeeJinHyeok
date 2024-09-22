package com.jinhyeok.assignment4.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record BoardCreateRequest(
        @NotBlank
        @Schema(description = "Board의 제목", example = "Board title")
        String title,
        @Schema(description = "Board의 내용", example = "I am a board.")
        String content
) {
}
