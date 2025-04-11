package com.spring.genai.bfs.springboot_gemini_bfs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

@Configuration
public class GoogleAiGeminiConfig {
    
    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    @Value("${GEMINI_MODEL_NAME}")
    private String modelName;
    
    @Bean
    public GoogleAiGeminiChatModel geminiModel() {
        return GoogleAiGeminiChatModel.builder()
        .apiKey(apiKey)
        .modelName(modelName).build();
    }
}
