package com.adam.flowboard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adam.flowboard.domain.entity.WorkspaceMembership;

public interface WorkspaceMembershipRepository extends JpaRepository<WorkspaceMembership, UUID>{
    
    boolean existsByUserIdAndWorkspaceId(UUID userId, UUID workspaceId);

    Optional<WorkspaceMembership> findByUserIdAndWorkspaceId(
        UUID userId,
        UUID workspaceId
    );
}
