package com.adam.flowboard.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.adam.flowboard.repository.WorkspaceMembershipRepository;

@Service
public class WorkspaceMembershipService {
    private final WorkspaceMembershipRepository workspaceMembershipRepository;

    public WorkspaceMembershipService(WorkspaceMembershipRepository workspaceMembershipRepository){
        this.workspaceMembershipRepository = workspaceMembershipRepository;
    }
    public boolean isMember(UUID userId, UUID workspaceId){
        return workspaceMembershipRepository.existsByUserIdAndWorkspaceId(userId, workspaceId);
    }
    
}
