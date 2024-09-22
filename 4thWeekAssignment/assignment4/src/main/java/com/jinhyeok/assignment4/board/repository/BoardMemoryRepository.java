package com.jinhyeok.assignment4.board.repository;

import com.jinhyeok.assignment4.board.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardMemoryRepository implements BoardRepository {
    private final AtomicLong boardIdxGenerator = new AtomicLong(0);
    private final Map<Long, Board> boardMap = new HashMap<Long, Board>();

    @Override
    public Board save(Board board) {
        if (board.getId() == null) {
            board.setId(boardIdxGenerator.incrementAndGet());
            boardMap.put(board.getId(), board);
            return board;
        } else {
            boardMap.replace(board.getId(), board);
            return board;
        }
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.of(boardMap.get(id));
    }

    @Override
    public List<Board> findAll() {
        return boardMap.values().stream().toList();
    }

    @Override
    public Long deleteById(Long id) {
        boardMap.remove(id);
        return id;
    }
}
