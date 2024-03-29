package com.example.aspectDemo;

import com.example.aspectDemo.service.NameCounter;
import com.example.aspectDemo.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AspectDemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(AspectDemoApplication.class, args);


        //self (obvious) comment: this should go to run() if you want Aspects to work in run()
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User MainUser = context.getBean("user", User.class);
        NameCounter mainNameCounter = context.getBean("nameCounter", NameCounter.class);

        System.out.println("User name from main() is: " + MainUser.getName() + "\n");

        mainNameCounter.countLetters(MainUser);

        someMethod();

    }

    public static void someMethod() {
        System.out.println("Some method = hello there.");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("================>>>> run() starts here...");
        User testUser = new User("Run Smith");
        NameCounter nameCounter = new NameCounter();

        System.out.println("User name is: " + testUser.getName());
        nameCounter.countLetters(testUser);

        System.out.println("================>>>> end of run()" + "\n");

    }
}
