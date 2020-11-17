package com.example.demo.api;

import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    private CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    //@GetMapping("/api/isPalindrome")
    //public boolean isPalindrome(String str) {
     //   return CardService.isPalindrome(str);
   // }

    //@GetMapping("/api/palindromeStrings")
   // public List<String> getPalindromeStrings() {
      //  return service.getPalindromeStrings();
    //}

}
