package com.sherry.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/myCards")
    public String getCardsDetails() {
        return "here are the cards details";
    }
}
