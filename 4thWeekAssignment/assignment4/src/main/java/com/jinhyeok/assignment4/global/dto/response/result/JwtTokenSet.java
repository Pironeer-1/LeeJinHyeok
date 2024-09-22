package com.jinhyeok.assignment4.global.dto.response.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtTokenSet {
    @Schema(description = "타입")
    private String grantType;

    @Schema(description = "토큰")
    private String token;

    @Builder
    public JwtTokenSet(String token) {
        this.token = token;
    }
}
