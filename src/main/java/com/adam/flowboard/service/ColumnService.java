package com.adam.flowboard.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adam.flowboard.domain.entity.Board;
import com.adam.flowboard.domain.entity.Column;
import com.adam.flowboard.repository.BoardRepository;
import com.adam.flowboard.repository.ColumnRepository;

import jakarta.transaction.Transactional;

@Service
public class ColumnService {
    private final BoardRepository boardRepository;

    public ColumnService(ColumnRepository columnRepository, BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }


    @Transactional
    public Column createColumn(UUID boardId, String name, Integer position){
        Board board = boardRepository.findById(boardId).orElseThrow();

        Column column = new Column(name, position);
        board.addColumn(column);
        return column;
    }

}
