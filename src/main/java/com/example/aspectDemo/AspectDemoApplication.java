package com.example.aspectDemo;

import com.example.aspectDemo.service.NameCounter;
import com.example.aspectDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AspectDemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        System.out.println("main starts here");
        SpringApplication.run(AspectDemoApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User MainUser = (User) context.getBean("user");
        NameCounter MainNameCounter = context.getBean("nameCounter", NameCounter.class);

        System.out.println("User name from main() is: " + MainUser.getName());

		MainNameCounter.countLetters(MainUser);


    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("================>>>> run() starts here...");
        User testUser = new User("Bad Motherfucker");
        NameCounter nameCounter = new NameCounter();

        System.out.println("User name is: " + testUser.getName());
        nameCounter.countLetters(testUser);

        System.out.println("================>>>> end of run()");

    }
}
