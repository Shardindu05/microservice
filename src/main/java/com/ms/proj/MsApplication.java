package com.ms.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
		System.out.println("Server Started!!!");
	}

}
