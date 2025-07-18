package com.example.demo.dto;

public class TranslationResponse {
    private String translatedText;
    // Default constructor
    public TranslationResponse(String translatedText) {
        this.translatedText = translatedText;
    }
    
    public String getTranslatedText() {
        return translatedText;
    }

    // Setter method for translatedText
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}