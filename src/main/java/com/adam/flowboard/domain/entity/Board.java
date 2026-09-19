package com.adam.flowboard.domain.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @UuidGenerator
    private UUID id;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private String name;

    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @OneToMany(
        mappedBy = "board",
        cascade = CascadeType.ALL,
        orphanRemoval = true

    )
    private List<Column> columns = new ArrayList<>();
    
    protected Board() {
        // Hibernate only
    }

    public Board(String name){
        this.name = name;
    }
    

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
    public String getName(){
        return name;
    } 

    public void setName(String name){
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void addColumn(Column column) {
        columns.add(column);
        column.setBoard(this);
    }

    public List<Column> getColumns() {
        return columns;
    }
}
