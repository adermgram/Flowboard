package com.adam.flowboard.dto.error;

import java.time.Instant;

public record ErrorResponse(
    String message,                 
    Instant timestamp,
    String url
) {}
