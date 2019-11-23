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
		SpringApplication.run(AspectDemoApplication.class, args);

		ApplicationContext context =
		new ClassPathXmlApplicationContext("Beans.xml");

		User user = (User) context.getBean("user");
	//	User user = new User("Main Motherfucker");
		System.out.println(user.getName());

	}





	@Override
	public void run(String... args) throws Exception {
		System.out.println("================>>>> test starts here...");
		User testUser = new User("Bad Motherfucker");
		NameCounter nameCounter = new NameCounter();

		System.out.println("User name is: "+ testUser.getName());
		nameCounter.countLetters(testUser);

		System.out.println("============================");

	}
}
