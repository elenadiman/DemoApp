package com.example.demo.service;

import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    private Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1)
            return true;
        if (str.charAt(0) == str.charAt(str.length() - 1))
            return isPalindrome(str.substring(1, str.length() - 1));
        return false;
    }

    public List<String> getPalindromeStrings() {
        return repository.getStrings().stream().filter(Service::isPalindrome).collect(Collectors.toList());
    }


}
