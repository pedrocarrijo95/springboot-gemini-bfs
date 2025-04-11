package com.spring.genai.bfs.springboot_gemini_bfs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;


@Service
public class GoogleAiGeminiService {


    private final ChatLanguageModel gemini;

    public GoogleAiGeminiService(ChatLanguageModel gemini) {
        this.gemini = gemini;
    }

    public String getResponse(String prompt) {
        String systemPrompt = """
        You are an assistant that explains the result of an island-count analysis on a grid of 1s (land) and 0s (water).

        Given the total number of islands found using a BFS algorithm, respond clearly and in natural, friendly language, as if talking to a non-technical person.

        Always mention that the calculation was done using the BFS algorithm.

        Be direct, kind, and avoid technical terms. Always end your response without asking any questions.
        """;        
        ChatRequest chatRequest = ChatRequest.builder().messages(List.of(SystemMessage.from(systemPrompt),UserMessage.from(prompt))).build();
        ChatResponse chatResponse = gemini.chat(chatRequest);
        return chatResponse.aiMessage().text();
    }

}
