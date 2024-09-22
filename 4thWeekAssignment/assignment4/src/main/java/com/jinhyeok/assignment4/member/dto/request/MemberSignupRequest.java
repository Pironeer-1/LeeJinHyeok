package com.jinhyeok.assignment4.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberSignupRequest(
        @NotBlank
        @Schema(description = "ID", example = "kmer1024")
        String memberId,
        @NotBlank
        @Schema(description = "Password", example = "Badgaadh!!")
        String password,
        @NotBlank
        @Schema(description = "UserName", example = "Jinhyeok")
        String userName
) {
}
