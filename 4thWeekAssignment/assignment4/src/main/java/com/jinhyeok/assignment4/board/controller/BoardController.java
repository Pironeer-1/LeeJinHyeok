package com.jinhyeok.assignment4.board.controller;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.dto.request.BoardUpdateRequest;
import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.board.service.BoardService;
import com.jinhyeok.assignment4.global.dto.response.SuccessResponse;
import com.jinhyeok.assignment4.global.dto.response.result.ListResult;
import com.jinhyeok.assignment4.global.dto.response.result.SingleResult;
import com.sun.net.httpserver.Authenticator;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Board 생성")
    public SuccessResponse<SingleResult<BoardResponse>> create(@Valid @RequestBody BoardCreateRequest request) {
        SingleResult<BoardResponse> boardResponse = boardService.save(request);
        return SuccessResponse.ok(boardResponse);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "Board 단건 조회")
    public SuccessResponse<SingleResult<BoardResponse>> read(@PathVariable("boardId") Long id) {
        SingleResult<BoardResponse> boardResponse = boardService.findById(id);
        return SuccessResponse.ok(boardResponse);
    }
    //CRUD (Read는 단건조회 + 전체 조회)

    @GetMapping
    @Operation(summary = "Board 전체 조회")
    public SuccessResponse<ListResult<BoardResponse>> readAll() {
        ListResult<BoardResponse> boardResponseList = boardService.findAll();
        return SuccessResponse.ok(boardResponseList);
    }

    @PutMapping
    @Operation(summary = "Board 수정")
    public SuccessResponse<SingleResult<BoardResponse>> update(@Valid @RequestBody BoardUpdateRequest request) {
        SingleResult<BoardResponse> boardResponse = boardService.update(request);
        return SuccessResponse.ok(boardResponse);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "Board 삭제 ")
    public SuccessResponse<SingleResult<Long>> delete(@PathVariable("boardId") Long id) {
        SingleResult<Long> deletedId = boardService.deleteById(id);
        return SuccessResponse.ok(deletedId);
    }
}
