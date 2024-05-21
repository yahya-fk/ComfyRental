package com.example.comfyrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ComfyRentalApplication {

    public static void main(String[] args) {

        SpringApplication.run(ComfyRentalApplication.class, "Hello world");
    }


}
