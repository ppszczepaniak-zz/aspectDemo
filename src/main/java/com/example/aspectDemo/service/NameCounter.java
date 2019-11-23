package com.example.aspectDemo.service;

import com.example.aspectDemo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class NameCounter {

    public void countLetters(User user) {
        int numberOfLetters = 0;

        for (int i = 0; i < user.getName().length(); i++) {
            if (Character.isLetter(user.getName().charAt(i)))
                numberOfLetters++;
        }
        System.out.println("Letters: " + numberOfLetters);
    }

}



