package com.example.demo.api;

import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/api/isPalindrome")
    public boolean isPalindrome(String str) {
        return Service.isPalindrome(str);
    }

    @GetMapping("/api/palindromeStrings")
    public List<String> getPalindromeStrings() {
        return service.getPalindromeStrings();
    }

}
