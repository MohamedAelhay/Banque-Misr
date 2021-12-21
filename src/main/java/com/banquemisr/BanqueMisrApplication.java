package com.banquemisr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BanqueMisrApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueMisrApplication.class, args);
    }

}
