package com.jinhyeok.assignment4.member.dto.response;

import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MemberResponse(
        @NotNull
        @Schema(description = "User ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "MemberID", example = "kmer1024")
        String memberId,
        @NotBlank
        @Schema(description = "MemberName", example = "jinhyeok")
        String userName) {
    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .userName(member.getUserName())
                .build();
    }
}
