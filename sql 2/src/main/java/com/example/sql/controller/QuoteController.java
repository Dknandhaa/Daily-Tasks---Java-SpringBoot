package com.example.sql.controller;

import com.example.sql.model.quote;
import com.example.sql.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuoteController {
    private static final String VALID_TOKEN = "12345";
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/fetch-quotes")
    public List<quote> getQuotes(@RequestParam("token")String token) {
        List<quote> quotes = quoteService.getAllQuotes();

//        if (quotes.isEmpty()) {
            if (token != null && token.equals(VALID_TOKEN)) {
                quoteService.fetchAndSaveQuotes();
                quotes = quoteService.getAllQuotes();
            }

//        }

        return quotes;
    }
}

