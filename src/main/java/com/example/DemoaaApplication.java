package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// exclude = SecurityAutoConfiguration.class
@SpringBootApplication()
@MapperScan("com.example.dao")
public class DemoaaApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoaaApplication.class, args);
    }
}
