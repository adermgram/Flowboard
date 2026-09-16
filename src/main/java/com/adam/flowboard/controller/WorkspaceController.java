package com.adam.flowboard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.flowboard.domain.entity.Workspace;
import com.adam.flowboard.dto.workspace.CreateWorkspaceRequest;
import com.adam.flowboard.service.WorkspaceService;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService){
        this.workspaceService = workspaceService;
    }

    @PostMapping
    public Workspace createWorkspace(@RequestBody CreateWorkspaceRequest request){
        return workspaceService.createWorkspace(request.name());
    }
    
}
