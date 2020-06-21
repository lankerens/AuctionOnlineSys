package com.lankeren.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AuctiononlinesysApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctiononlinesysApplication.class, args);
    }

}
