package com.adam.flowboard.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.adam.flowboard.domain.entity.WorkspaceMembership;
import com.adam.flowboard.domain.entity.WorkspaceRole;
import com.adam.flowboard.exception.ForbiddenException;
import com.adam.flowboard.exception.MembershipNotFoundException;
import com.adam.flowboard.repository.WorkspaceMembershipRepository;
import com.adam.flowboard.exception.MembershipNotFoundException;

@Service
public class WorkspaceMembershipService {
    private final WorkspaceMembershipRepository workspaceMembershipRepository;

    public WorkspaceMembershipService(WorkspaceMembershipRepository workspaceMembershipRepository){
        this.workspaceMembershipRepository = workspaceMembershipRepository;
    }
    public boolean isMember(UUID userId, UUID workspaceId){
        return workspaceMembershipRepository.existsByUserIdAndWorkspaceId(userId, workspaceId);
    }

    
   public WorkspaceMembership getMembership(UUID userId, UUID workspaceId) {
        return workspaceMembershipRepository
            .findByUserIdAndWorkspaceId(userId, workspaceId)
            .orElseThrow(MembershipNotFoundException::new);
    }

    public void requireRole(UUID userId, UUID workspaceId, WorkspaceRole requiredRole) {
        WorkspaceMembership membership = getMembership(userId, workspaceId);

        WorkspaceRole userRole = membership.getRole();

        if(!userRole.hasAtLeast(requiredRole)){
            throw new ForbiddenException();
        }
    }
    
}
