package com.jinhyeok.assignment4.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberLoginRequest(
        @NotBlank
        @Schema(description = "ID", example = "kmer1024")
        String memberId,
        @NotBlank
        @Schema(description = "Password", example = "dlaghlagh!!")
        String password
) {
}
