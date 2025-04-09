package com.spring.genai.bfs.springboot_gemini_bfs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.genai.bfs.springboot_gemini_bfs.model.IslandRequest;
import com.spring.genai.bfs.springboot_gemini_bfs.service.GoogleAiGeminiService;
import com.spring.genai.bfs.springboot_gemini_bfs.service.NumberOfIslandsBFS;

@RestController
@RequestMapping("/api/ai")
public class AppController {

    private final GoogleAiGeminiService geminiService;

    public AppController(GoogleAiGeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/response")
    public String response(@RequestBody IslandRequest request) {
        char[][] grid = request.getGrid();
        String language = request.getLanguage();

        NumberOfIslandsBFS numberofislandsbfs = new NumberOfIslandsBFS();
        int islands_count = numberofislandsbfs.numIslands(grid);

        String prompt = "The total number of islands found was: " + islands_count + " | answer in "+language;
        return geminiService.getResponse(prompt);
    }

}
