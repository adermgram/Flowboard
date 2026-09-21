package com.adam.flowboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adam.flowboard.domain.entity.Board;
import com.adam.flowboard.domain.entity.Workspace;
import com.adam.flowboard.repository.BoardRepository;
import com.adam.flowboard.repository.WorkspaceRepository;



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
    
    @Transactional(readOnly = true)
    public List<Board> getBoards(UUID workspaceId){
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow();
        return workspace.getBoards();
    }
}
