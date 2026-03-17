package com.princeagrawal.ai.logintelligence.mapper.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.princeagrawal.ai.logintelligence.model.response.LogResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResponseMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();
    public LogResponseDto mapToLogResponseDto(String response) {
        try {
            log.debug("Raw LLM response: {}", response);
            String clean = extractJson(response);
            log.debug("Clean JSON: {}", clean);
            return objectMapper.readValue(clean, LogResponseDto.class);
        } catch (Exception e) {
            log.error("Parsing failed", e);
            return LogResponseDto.builder().rootCause("Failed to parse LLM response")
                    .possibleReasons("Invalid JSON returned by model")
                    .suggestedFix("Check prompt or add stricter output format").build();
        }
    }

    private String extractJson(String response) {
        int start = response.indexOf("{");
        int end = response.lastIndexOf("}");
        if (start != -1 && end != -1 && end > start) {
            return response.substring(start, end + 1);
        }
        throw new RuntimeException("No valid JSON found in response");
    }
}
