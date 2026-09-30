package com.adam.flowboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adam.flowboard.domain.entity.Board;
import com.adam.flowboard.domain.entity.Workspace;
import com.adam.flowboard.domain.entity.WorkspaceMembership;
import com.adam.flowboard.domain.entity.WorkspaceRole;
import com.adam.flowboard.exception.ForbiddenException;
import com.adam.flowboard.repository.BoardRepository;
import com.adam.flowboard.repository.WorkspaceRepository;



@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;
	private final WorkspaceMembershipService workspaceMembershipService;

    public BoardService(
            BoardRepository boardRepository, 
            WorkspaceRepository workspaceRepository, 
            WorkspaceMembershipService workspaceMembershipService
        ){
        this.boardRepository = boardRepository;
        this.workspaceRepository = workspaceRepository;
        this.workspaceMembershipService = workspaceMembershipService;
    }

    @Transactional
    public Board createBoard(UUID workspaceId, UUID userId, String name) {

        workspaceMembershipService.requireRole(
            userId,
            workspaceId,
            WorkspaceRole.ADMIN
        );

        Workspace workspace = workspaceRepository
            .findById(workspaceId)
            .orElseThrow();

        Board board = new Board(name);
        workspace.addBoard(board);

        return board;
    }
    
    @Transactional(readOnly = true)
    public List<Board> getBoards(UUID userId, UUID workspaceId){
        
        if (!workspaceMembershipService.isMember(userId, workspaceId)){
            throw new ForbiddenException();
        }
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow();
        return workspace.getBoards();
    }
}
