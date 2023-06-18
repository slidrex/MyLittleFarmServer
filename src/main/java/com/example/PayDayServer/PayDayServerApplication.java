package com.example.PayDayServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.DriverManager;

@SpringBootApplication
public class PayDayServerApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(PayDayServerApplication.class, args);
	}
}
