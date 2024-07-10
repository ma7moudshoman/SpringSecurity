package com.spring.springsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

  /*  @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
        UserDetails user=
                User.withUsername("Bate5a")
                        .password(passwordEncoder().encode("123"))
                        .authorities("read")
                        .build();

        userDetailsManager.createUser(user);
        return userDetailsManager;

    }*/

@Bean
 BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws  Exception{
                http.formLogin();
                http.authorizeHttpRequests().requestMatchers("/hello").authenticated()
                .anyRequest().denyAll();

        return http.build();
    }








}
