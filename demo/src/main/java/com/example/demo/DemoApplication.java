package com.example.demo;

import com.example.demo.config.PayloadConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

@SpringBootApplication
@EnableConfigurationProperties(PayloadConfig.class)
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Configuration
    @EnableScheduling
    static class Scheduling{
        @Scheduled(initialDelay = 1000L, fixedDelayString = "${job.delay}")
        void someJob() {
            String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "postgres";

            String csvFilePath = "NotProcessedCards.csv";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                String query = "SELECT * FROM card WHERE processed='false'";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

                fileWriter.write("id, card_no, type, balance, valid_from, valid_to, status, visible_pan, processed");
                while (result.next()) {
                    Long id = result.getLong("id");
                    String cardNo = result.getString("card_no");
                    String type = result.getString("type");
                    Long balance = result.getLong("balance");
                    Date validFrom = result.getDate("valid_from");
                    Date validTo = result.getDate("valid_to");
                    String status = result.getString("status");
                    String visiblePan = result.getString("visible_pan");
                    boolean processed = result.getBoolean("processed");

                    String line = String.format("%d , %s, %s, %d, %s, %s, %s, %s, %s",
                            id, cardNo, type, balance, validFrom, validTo, status, visiblePan, processed);
                    fileWriter.newLine();
                    fileWriter.write(line);
                    System.out.println("row added");
                }
                statement.close();
                fileWriter.close();


            } catch (SQLException e) {
                System.out.println("Database error: ");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("File IO error");
                e.printStackTrace();
            }
        }
    }


}


