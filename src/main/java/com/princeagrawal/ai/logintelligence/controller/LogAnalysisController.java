package com.princeagrawal.ai.logintelligence.controller;

import com.princeagrawal.ai.logintelligence.model.request.LogRequestDto;
import com.princeagrawal.ai.logintelligence.model.response.LogResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.princeagrawal.ai.logintelligence.service.LogAnalysisService;

@RestController
@RequestMapping("/api/logs")
public class LogAnalysisController {

    private final LogAnalysisService service;

    public LogAnalysisController(LogAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public ResponseEntity<LogResponseDto> analyze(@RequestBody LogRequestDto request) {
        LogResponseDto responseDto = service.analyzeLogs(request.getLogs());
        return ResponseEntity.ok(responseDto);
    }
}

