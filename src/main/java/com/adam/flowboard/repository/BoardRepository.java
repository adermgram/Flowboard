package com.adam.flowboard.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adam.flowboard.domain.entity.Board;
public interface BoardRepository extends JpaRepository<Board, UUID>{
    
}
