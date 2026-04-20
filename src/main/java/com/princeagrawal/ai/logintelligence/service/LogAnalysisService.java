package com.princeagrawal.ai.logintelligence.service;

import com.princeagrawal.ai.logintelligence.mapper.request.RequestMapper;
import com.princeagrawal.ai.logintelligence.mapper.response.ResponseMapper;
import com.princeagrawal.ai.logintelligence.model.response.LogResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.princeagrawal.ai.logintelligence.config.CacheConfig.LOGS_CACHE;

@Service
public class LogAnalysisService {
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final ChatClient chatClient;

    public LogAnalysisService(RequestMapper requestMapper, ResponseMapper responseMapper, ChatClient.Builder builder) {
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        this.chatClient = builder.build();
    }
    @Cacheable(LOGS_CACHE)
    public LogResponseDto analyzeLogs(String inputErrorLog) {
        String requestPrompt = requestMapper.mapInputErrorLogToRequestDto(inputErrorLog);
        String response = chatClient.prompt().user(requestPrompt).call().content();
        return responseMapper.mapToLogResponseDto(response);
    }
}
