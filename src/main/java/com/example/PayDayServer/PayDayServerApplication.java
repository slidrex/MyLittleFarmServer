package com.example.PayDayServer;

import org.flywaydb.core.FlywayExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.sql.DriverManager;

@SpringBootApplication
public class PayDayServerApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(PayDayServerApplication.class, args);
	}
}
