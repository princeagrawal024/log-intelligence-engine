package com.princeagrawal.ai.logintelligence.validation;

public class LogInputValidator {

    private static final int MIN_LENGTH = 20;
    private static final int MAX_LENGTH = 5000;

    public static void validateInputErrorLog(String inputErrorLog) {
        if (inputErrorLog == null || inputErrorLog.trim().isEmpty()) {
            throw new IllegalArgumentException("Log input cannot be null or empty");
        }

        String trimmed = inputErrorLog.trim();
        if (trimmed.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Log input too small to analyze");
        }

        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Log input too large, please trim logs");
        }

        if (!containsErrorKeywords(trimmed)) {
            throw new IllegalArgumentException("Input does not appear to be a valid error log");
        }

        if (isLikelyPlainText(trimmed)) {
            throw new IllegalArgumentException("Input looks like plain text, not logs");
        }
    }

    private static boolean containsErrorKeywords(String log) {
        String lower = log.toLowerCase();

        return lower.contains("exception") || lower.contains("error") || lower.contains("failed")
                || lower.contains("stacktrace") || lower.contains("caused by");
    }

    private static boolean isLikelyPlainText(String log) {
        return !log.contains(" at ") && !log.contains("Caused by");
    }
}
