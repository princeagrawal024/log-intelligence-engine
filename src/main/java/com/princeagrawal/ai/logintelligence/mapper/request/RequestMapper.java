package com.princeagrawal.ai.logintelligence.mapper.request;

import com.princeagrawal.ai.logintelligence.prompt.LogPromptBuilder;
import org.springframework.stereotype.Service;

@Service
public class RequestMapper {
    public String mapInputErrorLogToRequestDto(String inputErrorLog) {
        return LogPromptBuilder.buildPrompt(inputErrorLog);
    }
}
