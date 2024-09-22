package com.jinhyeok.assignment4.board.controller;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.board.service.BoardService;
import com.jinhyeok.assignment4.global.dto.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public SuccessResponse<BoardResponse> create(@Valid @RequestBody BoardCreateRequest request) {
        BoardResponse boardResponse = boardService.save(request);
        return SuccessResponse.ok(boardResponse);
    }

    @GetMapping("/{boardId}")
    public SuccessResponse<BoardResponse> read(@PathVariable("boardId") Long id) {
        BoardResponse boardResponse = boardService.findById(id);
        return SuccessResponse.ok(boardResponse);
    }
    //CRUD (Read는 단건조회 + 전체 조회)

}
