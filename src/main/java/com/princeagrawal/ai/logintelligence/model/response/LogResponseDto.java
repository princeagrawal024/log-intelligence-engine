package com.princeagrawal.ai.logintelligence.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogResponseDto {
    private String rootCause;
    private String possibleReasons;
    private String suggestedFix;
}
