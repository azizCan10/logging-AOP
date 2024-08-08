package com.test.loggingAOP.controller;

import com.test.loggingAOP.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/log")
public class LogController {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<String> successfulLog() {
        return ResponseEntity.ok(logService.successfulLog("successful log"));
    }

    @GetMapping("/error")
    public ResponseEntity<String> errorLog() {
        return ResponseEntity.ok(logService.errorLog("error log"));
    }
}
