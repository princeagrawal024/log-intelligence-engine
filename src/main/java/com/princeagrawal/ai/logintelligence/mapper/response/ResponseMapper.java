package com.princeagrawal.ai.logintelligence.mapper.response;

import com.princeagrawal.ai.logintelligence.model.response.LogResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ResponseMapper {

    public LogResponseDto mapToLogResponseDto(String response) {
        return LogResponseDto.builder()
                .rootCause(response)
                .possibleReasons("possible reason")
                .suggestedFix("suggested fix")
                .build();
    }
}
