package com.princeagrawal.ai.logintelligence.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogResponseDto {
    private String rootCause;
    private String possibleReasons;
    private String suggestedFix;
}
