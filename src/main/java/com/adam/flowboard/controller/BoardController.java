package com.adam.flowboard.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.flowboard.domain.entity.Board;
import com.adam.flowboard.dto.board.CreateBoardRequest;
import com.adam.flowboard.service.BoardService;

@RestController
@RequestMapping("/api/workspaces")

public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("{workspaceId}/boards")
    public Board createBoard(@RequestBody CreateBoardRequest request, @PathVariable UUID workspaceId){

        return boardService.createBoard(workspaceId, request.name());
    }

    @GetMapping("{workspaceId}/boards")
    public List<Board> getBoards(@PathVariable UUID workspaceId, Authentication authentication){

        UUID userId = (UUID) authentication.getPrincipal();
        return boardService.getBoards(userId, workspaceId);
    }

}
