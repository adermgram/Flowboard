package com.adam.flowboard.dto.error;

import java.time.Instant;
import java.util.Map;

public record ValidationErrorResponse(
    String message,
    Instant timestamp,
    String url,
    Map<String, String> errors
) {}