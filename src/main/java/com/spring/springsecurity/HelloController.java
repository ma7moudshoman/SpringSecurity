package com.spring.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  //  GET http://localhost:8080/hello
    @GetMapping("/hello")
    public  String hello(){
        return  "Hello Spring Security a3oooo !  Hello ";
    }
    //  GET http://localhost:8080/hi
    @GetMapping("/hi")
    public  String hi(){
        return  "Hello Spring Security a3oooo !! Hi ";
    }

}
