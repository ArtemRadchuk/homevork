package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Crud {

    public static void main(String[] args) {
       SpringApplication.run(Crud.class, args);
    }
}
