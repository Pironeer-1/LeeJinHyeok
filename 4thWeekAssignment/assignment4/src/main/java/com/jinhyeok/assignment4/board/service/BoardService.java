package com.jinhyeok.assignment4.board.service;

import com.jinhyeok.assignment4.board.dto.request.BoardCreateRequest;
import com.jinhyeok.assignment4.board.dto.request.BoardUpdateRequest;
import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.board.mapper.BoardMapper;
import com.jinhyeok.assignment4.board.repository.BoardRepository;
import com.jinhyeok.assignment4.global.exception.CustomException;
import com.jinhyeok.assignment4.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BoardResponse> findAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponse> boardResponseList = boardList.stream().map(BoardResponse::of).toList();
        return boardResponseList;
    }

    public BoardResponse update(BoardUpdateRequest boardUpdateRequest) {
        Board board = boardRepository.findById(boardUpdateRequest.id())
                        .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        Board updatedBoard = boardRepository.save(board.update(boardUpdateRequest));
        return BoardResponse.of(updatedBoard);
    }
}
