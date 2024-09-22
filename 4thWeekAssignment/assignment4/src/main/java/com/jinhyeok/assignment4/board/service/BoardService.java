package com.jinhyeok.assignment4.board.service;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.board.mapper.BoardMapper;
import com.jinhyeok.assignment4.board.repository.BoardRepository;
import com.jinhyeok.assignment4.global.exception.CustomException;
import com.jinhyeok.assignment4.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponse save(BoardCreateRequest boardCreateRequest) {
        Board savedBoard = boardRepository.save(BoardMapper.from(boardCreateRequest));
        return BoardResponse.of(savedBoard);
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));

        return BoardResponse.of(board);
    }
}
