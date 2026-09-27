package com.adam.flowboard.controller;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.flowboard.dto.workspace.CreateWorkspaceRequest;
import com.adam.flowboard.dto.workspace.WorkspaceResponse;
import com.adam.flowboard.service.WorkspaceService;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService){
        this.workspaceService = workspaceService;
    }
    
    @PostMapping
    public WorkspaceResponse createWorkspace(
        @RequestBody CreateWorkspaceRequest request, 
        Authentication authentication
    ){
        UUID userId = (UUID) authentication.getPrincipal();
    
        return workspaceService.createWorkspace(userId, request.name());
    }
    
}
