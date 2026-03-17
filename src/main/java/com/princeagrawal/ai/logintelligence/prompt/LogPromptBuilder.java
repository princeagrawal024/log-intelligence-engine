package com.princeagrawal.ai.logintelligence.prompt;

import lombok.Data;

@Data
public class LogPromptBuilder {
    public static String buildPrompt(String logs) {
        return """
                You are a senior SRE engineer.

                Analyze the following logs and return STRICT JSON ONLY.

                Do NOT add explanation.
                Do NOT add markdown.
                Do NOT add extra text.

                Return response in EXACT format:

                {
                  "rootCause": "...",
                  "possibleReasons": "...",
                  "suggestedFix": "..."
                }

                Rules:
                • rootCause → 1–2 lines
                • possibleReasons → bullet points in single string
                • suggestedFix → actionable steps

                Logs:
                """ + logs;
    }
}
