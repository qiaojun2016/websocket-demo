package com.example.websocketdemo.config;


import javax.security.auth.Subject;
import java.security.Principal;

public class Authentication implements Principal {
    private String name;

    public Authentication(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
