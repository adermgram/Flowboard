package com.adam.flowboard.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adam.flowboard.domain.entity.Board;
import com.adam.flowboard.domain.entity.Workspace;
import com.adam.flowboard.repository.BoardRepository;
import com.adam.flowboard.repository.WorkspaceRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;

    public BoardService(BoardRepository boardRepository, WorkspaceRepository workspaceRepository){
        this.boardRepository = boardRepository;
        this.workspaceRepository = workspaceRepository;
    }

    @Transactional
    public Board createBoard(UUID workspaceId, String name){
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow();

        Board board = new Board(name);
        workspace.addBoard(board);
        return board;
    }
    
}
