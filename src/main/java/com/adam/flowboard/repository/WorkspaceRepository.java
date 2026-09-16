package com.adam.flowboard.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adam.flowboard.domain.entity.Workspace;

public interface WorkspaceRepository  extends JpaRepository<Workspace, UUID>{
    
}
