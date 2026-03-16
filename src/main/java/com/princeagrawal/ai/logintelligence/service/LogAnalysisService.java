package com.princeagrawal.ai.logintelligence.service;

import com.princeagrawal.ai.logintelligence.mapper.response.ResponseMapper;
import com.princeagrawal.ai.logintelligence.model.response.LogResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import com.princeagrawal.ai.logintelligence.prompt.LogPromptBuilder;

@Service
public class LogAnalysisService {

    private final ResponseMapper responseMapper;
    private final ChatClient chatClient;

    public LogAnalysisService(ResponseMapper responseMapper, ChatClient.Builder builder) {
        this.responseMapper = responseMapper;
        this.chatClient = builder.build();
    }

    public LogResponseDto analyzeLogs(String logs) {
        // Call validator

        // Build prompt
        String prompt = LogPromptBuilder.buildPrompt(logs);

        // Call LLM
        String response = chatClient.prompt().user(prompt).call().content();
        // Response mapping
        return responseMapper.mapToLogResponseDto(response);
    }
}
