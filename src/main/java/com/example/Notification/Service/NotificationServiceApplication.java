package com.example.Notification.Service;

import com.example.Notification.Service.util.ConsoleHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
		ConsoleHelper.printGreetings();
		scanConsole();
	}

	public static void scanConsole() {
		Scanner scanner = new Scanner(System.in);
		for (String text;!(text = scanner.nextLine()).equals("close");) {}
		System.out.println("Server closed");
		System.exit(0);
	}

}
