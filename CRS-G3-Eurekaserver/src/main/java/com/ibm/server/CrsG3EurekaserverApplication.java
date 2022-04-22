package com.ibm.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CrsG3EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsG3EurekaserverApplication.class, args);
	}

}
