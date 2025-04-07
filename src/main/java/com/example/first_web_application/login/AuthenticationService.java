package com.example.first_web_application.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        if(username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

}
