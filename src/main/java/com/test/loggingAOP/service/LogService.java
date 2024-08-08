package com.test.loggingAOP.service;

import org.springframework.stereotype.Service;

@Service
public class LogService {

    public String successfulLog(String text) {
        return text;
    }

    public String errorLog(String text) {
        throw new RuntimeException(text);
    }
}
