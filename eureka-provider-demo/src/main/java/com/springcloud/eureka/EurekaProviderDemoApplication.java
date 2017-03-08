package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaProviderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderDemoApplication.class, args);
	}
}
