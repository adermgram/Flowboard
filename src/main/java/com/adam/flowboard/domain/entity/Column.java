package com.adam.flowboard.domain.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "columns")
public class Column {
    @Id
    @UuidGenerator
    private UUID id;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private String name;
    Integer position;


    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    
    protected Column() {
        // Hibernate only
    }
    
    public Column(String name, Integer postion){
        this.name = name;
        this.position = postion;
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

    public void setPosition(Integer position){
        this.position = position;
    }

    public Integer getPosition(){
        return position;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
}
