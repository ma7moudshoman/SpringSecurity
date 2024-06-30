package com.spring.springsecurity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String userName= authentication.getName();
       String Password=authentication.getCredentials().toString();
       if ("Bate5a" .equals(userName)  &&  "123".equals(Password)){
           return new UsernamePasswordAuthenticationToken( userName,Password , Arrays.asList());

       }else {
           throw new BadCredentialsException("Invalid username or password");
       }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
