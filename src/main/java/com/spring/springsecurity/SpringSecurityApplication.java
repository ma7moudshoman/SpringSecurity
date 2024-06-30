package com.spring.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurityApplication {

    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
