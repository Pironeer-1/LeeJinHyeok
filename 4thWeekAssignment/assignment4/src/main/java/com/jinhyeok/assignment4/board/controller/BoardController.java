package com.jinhyeok.assignment4.board.controller;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.dto.request.BoardUpdateRequest;
import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.board.service.BoardService;
import com.jinhyeok.assignment4.global.dto.response.SuccessResponse;
import com.sun.net.httpserver.Authenticator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public SuccessResponse<List<BoardResponse>> readAll() {
        List<BoardResponse> boardResponseList = boardService.findAll();
        return SuccessResponse.ok(boardResponseList);
    }

    @PutMapping
    public SuccessResponse<BoardResponse> update(@Valid @RequestBody BoardUpdateRequest request) {
        BoardResponse boardResponse = boardService.update(request);
        return SuccessResponse.ok(boardResponse);
    }

    @DeleteMapping("/{boardId}")
    public SuccessResponse<Long> delete(@PathVariable("boardId") Long id) {
        Long deletedId = boardService.deleteById(id);
        return SuccessResponse.ok(deletedId);
    }
}
