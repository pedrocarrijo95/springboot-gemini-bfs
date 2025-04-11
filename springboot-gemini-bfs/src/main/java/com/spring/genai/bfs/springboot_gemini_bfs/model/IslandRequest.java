package com.spring.genai.bfs.springboot_gemini_bfs.model;

public class IslandRequest {

    private char[][] grid;
    private String language;

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }

}
