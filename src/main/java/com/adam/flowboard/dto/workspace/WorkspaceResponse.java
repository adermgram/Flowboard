package com.adam.flowboard.dto.workspace;

import java.util.UUID;

public record WorkspaceResponse(
    UUID id,
    String name
) {} 
