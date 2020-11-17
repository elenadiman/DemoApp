package com.example.demo;

import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UnitTest {

    @Mock
    private CardRepository repository;

    @InjectMocks
    private CardService service;

    //@Test
   // public void getPalindromeStrings(){
       // given(repository.getStrings()).willReturn(new ArrayList<>(Arrays.asList("hello", "world", "mhm", "aha", "aa")));
      //  List<String>expected = service.getPalindromeStrings();
      //  Assertions.assertEquals(expected, List.of("mhm","aha","aa"));
   // }

}
