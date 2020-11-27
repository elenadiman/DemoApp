package com.example.demo.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "configuration")

public class PayloadConfig {

    int maximumRequestSize;

    public PayloadConfig(){}

    public PayloadConfig(int maximumRequestSize) {
        this.maximumRequestSize = maximumRequestSize;
    }
    public int getMaximumRequestSize() {
        return maximumRequestSize;
    }

    public void setMaximumRequestSize(int maximumRequestSize) {
        this.maximumRequestSize = maximumRequestSize;
    }

}
