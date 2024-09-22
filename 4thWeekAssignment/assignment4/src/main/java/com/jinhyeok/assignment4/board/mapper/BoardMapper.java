package com.jinhyeok.assignment4.board.mapper;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.entity.Board;

import java.time.LocalDateTime;

public class BoardMapper {
    public static Board from(BoardCreateRequest boardCreateRequest) {
        LocalDateTime now = LocalDateTime.now();

        return Board.builder()
                .title(boardCreateRequest.title())
                .content(boardCreateRequest.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
