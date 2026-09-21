package com.adam.flowboard.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.flowboard.domain.entity.Column;
import com.adam.flowboard.dto.column.CreateColumnRequest;
import com.adam.flowboard.service.ColumnService;

@RestController
@RequestMapping("/api/boards")

public class ColumnController {
    private final ColumnService columnService;

    public ColumnController(ColumnService columnService){
        this.columnService = columnService;
    }

    @PostMapping("/{boardId}/columns")
    public Column createColumn(@PathVariable UUID boardId,  @RequestBody CreateColumnRequest request){
        return columnService.createColumn(boardId, request.name(), request.position());
    }

    @GetMapping("/{boardId}/columns")
    public List<Column> getColumns(@PathVariable UUID boardId){
        return columnService.getColumns(boardId);
    }

    
}
