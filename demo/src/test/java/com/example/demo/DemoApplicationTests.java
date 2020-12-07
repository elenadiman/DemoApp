package com.example.demo;

import com.example.demo.config.PayloadConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = PayloadConfig.class)
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
