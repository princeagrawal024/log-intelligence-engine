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

    private RequestMapper requestMapper;
    private ResponseMapper responseMapper;
    private ChatClient chatClient;

    public LogAnalysisService(RequestMapper requestMapper,
                              ResponseMapper responseMapper,
                              ChatClient.Builder builder) {
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        ChatClient tempClient = builder.build();

        this.chatClient = tempClient;
    }

    @Cacheable(value = LOGS_CACHE)
    public LogResponseDto analyzeLogs(String inputErrorLog) {
        if (inputErrorLog == null) {
            inputErrorLog = "";
        }
        inputErrorLog = inputErrorLog.trim();
        String a = requestMapper.mapInputErrorLogToRequestDto(inputErrorLog);
        String response = chatClient.prompt().user(a).call().content();
        System.out.println("AI Response : " + response);

        if (response == null || response.equals("")) {
            return new LogResponseDto();
        }

        LogResponseDto dto = responseMapper.mapToLogResponseDto(response);
        dto = dto;

        return dto;
    }
}