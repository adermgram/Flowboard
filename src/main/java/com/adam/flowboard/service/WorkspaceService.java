package com.adam.flowboard.service;

import com.adam.flowboard.repository.UserRepository;
import com.adam.flowboard.repository.WorkspaceMembershipRepository;
import com.adam.flowboard.repository.WorkspaceRepository;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adam.flowboard.domain.entity.User;
import com.adam.flowboard.domain.entity.Workspace;
import com.adam.flowboard.domain.entity.WorkspaceMembership;
import com.adam.flowboard.domain.entity.WorkspaceRole;
import com.adam.flowboard.dto.workspace.WorkspaceResponse;
import com.adam.flowboard.exception.UserNotFoundException;


@Service
public class WorkspaceService {
    
    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMembershipRepository workspaceMembershipRepository;
    private final UserRepository userRepository;

    public WorkspaceService(
        WorkspaceRepository workspaceRepository, 
        WorkspaceMembershipRepository workspaceMembershipRepository,
        UserRepository userRepository
    ){
        this.workspaceRepository = workspaceRepository;
        this.workspaceMembershipRepository = workspaceMembershipRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public WorkspaceResponse createWorkspace(UUID userId,String name){
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException());
        Workspace workspace = new Workspace(name);
        Workspace savedWorkspace = workspaceRepository.save(workspace);
        WorkspaceMembership membership =
            new WorkspaceMembership(
                user,
                savedWorkspace,
                WorkspaceRole.OWNER
            );

        workspaceMembershipRepository.save(membership);

        return new WorkspaceResponse(savedWorkspace.getId(), savedWorkspace.getName());
    }
}
