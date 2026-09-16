package com.adam.flowboard.service;

import org.springframework.stereotype.Service;

import com.adam.flowboard.repository.WorkspaceRepository;
import com.adam.flowboard.domain.entity.Workspace;


@Service
public class WorkspaceService {
    
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository){
        this.workspaceRepository = workspaceRepository;
    }

    public Workspace createWorkspace(String name){
        Workspace newWorkspace = new Workspace(name);

        return workspaceRepository.save(newWorkspace);
    }
}
