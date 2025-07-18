package com.example.demo.service;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {

    
    private final Map<String, String> georgianToEnglishDictionary;

    public TranslationService() {
        georgianToEnglishDictionary = new HashMap<>();
        georgianToEnglishDictionary.put("გამარჯობა", "Hello");
        georgianToEnglishDictionary.put("მადლობა", "Thank you");
        georgianToEnglishDictionary.put("დიახ", "Yes");
        georgianToEnglishDictionary.put("არა", "No");
        georgianToEnglishDictionary.put("გემშვიდობებით", "Goodbye");
        georgianToEnglishDictionary.put("წყალი", "Water");
        georgianToEnglishDictionary.put("პური", "Bread");
        georgianToEnglishDictionary.put("სიყვარული", "Love");
        georgianToEnglishDictionary.put("სიმღერა", "sing" );
        georgianToEnglishDictionary.put("მეგობარი", "Friend");
        georgianToEnglishDictionary.put("ოჯახი", "Family");
        georgianToEnglishDictionary.put("სახლი", "House");
        georgianToEnglishDictionary.put("ქალაქი", "City");
        georgianToEnglishDictionary.put("მშვენიერი", "Wonderful");
        georgianToEnglishDictionary.put("მშვენიერი დღეა", "It's a wonderful day");
        georgianToEnglishDictionary.put("დაჩი", "Dachi");
        georgianToEnglishDictionary.put("მიყვარხარ", "I love you");
        georgianToEnglishDictionary.put("გილოცავ", "Congratulations");
        georgianToEnglishDictionary.put("გილოცავთ", "Congratulations to you");
        georgianToEnglishDictionary.put("გილოცავთ დაბადების დღეს", "Happy Birthday");
        georgianToEnglishDictionary.put("გილოცავთ ახალ წელს", "Happy New Year");
        georgianToEnglishDictionary.put("რას ამბობს მელია?", "what does the fox say?");
        georgianToEnglishDictionary.put("იქ არის ვარსკვლავკაცი", "there is a starman");

    }

    public String translateGeorgianToEnglish(String georgianText) {
        // შემოწმება, რომ ტექსტი არ არის null ან ცარიელი
        if (georgianText == null || georgianText.trim().isEmpty()) {
            return "";
        }
        // ტექსტის მოჭრა და თარგმნა
        String trimmedText = georgianText.trim();
        // თარგმნაში იგულისხმება , მოძებნა სიტყვის მიხედვით ჰაშმაპში , და შემდეგ მიღებული მნიშვნელობის 
        String translated = georgianToEnglishDictionary.get(trimmedText);

        if (translated != null) {
            return translated;
        } else {
            return "Translation not available for: \"" + trimmedText + "\"";
        }
    }
}