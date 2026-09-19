package com.adam.flowboard.domain.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Table(name = "workspaces")
public class Workspace {
    @Id
    @UuidGenerator
    private UUID id;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private String name;

    @OneToMany(
        mappedBy = "workspace",
        cascade = CascadeType.ALL,
        orphanRemoval = true

    )
    private List<Board> boards = new ArrayList<>();


    protected Workspace() {
        // Hibernate only
    }

    public Workspace(String name){
        this.name = name;
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

    public void addBoard(Board board) {
        boards.add(board);
        board.setWorkspace(this);
    }

    public List<Board> getBoards(){
        return boards;
    }
}
