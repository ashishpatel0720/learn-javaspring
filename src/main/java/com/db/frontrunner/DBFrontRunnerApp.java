package com.db.frontrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Spring will do everything for us, it will create a server container
 * and host the app for us we just need to add annotation. 
 * 
 * We need to tell Spring that that is starting point of Spring application
 * by adding @SpringBootApplication,
 * now spring will boot our application from this class's main method.
 */
@SpringBootApplication
public class DBFrontRunnerApp {
	public static void main(String[] args) {
		
		SpringApplication.run(DBFrontRunnerApp.class, args);
		//run from this class and pass arguments which might be passed through command line.
	}
}
