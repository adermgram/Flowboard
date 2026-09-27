package com.adam.flowboard.domain.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "workspace_memberships")
public class WorkspaceMembership {

    @Id
    @UuidGenerator
    private UUID id;

    @CreationTimestamp
    private Instant joinedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkspaceRole role;

    protected WorkspaceMembership() {
    }

    public WorkspaceMembership(
        User user,
        Workspace workspace,
        WorkspaceRole role
    ) {
        this.user = user;
        this.workspace = workspace;
        this.role = role;
    }
}