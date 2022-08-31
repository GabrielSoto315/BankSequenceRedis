package com.Bank.BankSequenceRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankSequenceRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSequenceRedisApplication.class, args);
	}

}
