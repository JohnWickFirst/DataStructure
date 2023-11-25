package com.hibernateDb.hbdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.hibernateDb.hbdb"})
public class HbdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbdbApplication.class, args);
	}

}
