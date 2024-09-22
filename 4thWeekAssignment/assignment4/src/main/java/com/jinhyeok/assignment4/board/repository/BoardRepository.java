package com.jinhyeok.assignment4.board.repository;

import com.jinhyeok.assignment4.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board topic);
    Optional<Board> findById(Long id);
    List<Board> findAll();
    Long deleteById(Long id);

}
