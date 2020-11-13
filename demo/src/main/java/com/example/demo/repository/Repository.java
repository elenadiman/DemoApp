package com.example.demo.repository;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    public ArrayList<String> getStrings() {
        return new ArrayList<>(List.of("hello", "world", "aha", "mhm", "aa"));
    }
}
