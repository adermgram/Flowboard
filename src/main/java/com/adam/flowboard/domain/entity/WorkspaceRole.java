package com.adam.flowboard.domain.entity;

public enum WorkspaceRole {
    OWNER(3),
    ADMIN(2),
    MEMBER(1);

    private final int level;

    WorkspaceRole(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    /**
     * Checks if this role has equal or greater permissions than the required role.
     * @param requiredRole The minimum role required for an action.
     * @return true if allowed, false otherwise.
     */
    public boolean hasAtLeast(WorkspaceRole requiredRole) {
        if (requiredRole == null) {
            return false;
        }
        return this.level >= requiredRole.getLevel();
    }
}
