package com.princeagrawal.ai.logintelligence.prompt;

import lombok.Data;

@Data
public class LogPromptBuilder {
    public static String buildPrompt(String logs) {
        return """
                You are a senior SRE engineer.

                Analyze the following application logs and find:

                1 Root cause
                2 Error summary
                3 Possible fix

                Logs:
                """ + logs;
    }
}
