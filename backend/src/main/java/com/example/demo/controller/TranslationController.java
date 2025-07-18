package com.example.demo.controller;

import com.example.demo.dto.TranslationRequest;
import com.example.demo.dto.TranslationResponse;
import com.example.demo.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TranslationController {
    //okay , so here we are creating a controller that will handle the translation requests
    // meaning that we created a service , in to what we will input the text to be translated
    private final TranslationService translationService;
    
    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }
    // This method handles POST requests to /api/translate
    @PostMapping("/translate")
    //keyword here is @RequestBody TranslationRequest it means that we are expecting a JSON body in the request
    public ResponseEntity<?> translate(@RequestBody TranslationRequest request) {
        // We call the service to translate the text from Georgian to English
        String translatedText = translationService.translateGeorgianToEnglish(request.getText());
        // We return the translated text wrapped in a TranslationResponse object
        return ResponseEntity.ok(new TranslationResponse(translatedText));
    }
}