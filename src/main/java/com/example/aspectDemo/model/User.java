package com.example.aspectDemo.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.StringJoiner;

public class User {
    private String name;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
