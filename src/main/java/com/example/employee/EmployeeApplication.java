package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The spring boot class of the Employee application.
 * 
 * @author Sharanya
 *
 */

@SpringBootApplication
public class EmployeeApplication {

	/**
	 * The main() that runs on start-up of the application. The method also sets the
	 * application context path using System.setProperty().
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// setting the context path insdie the java class
		// System.setProperty("server.servlet.context-path", "/employee");
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
