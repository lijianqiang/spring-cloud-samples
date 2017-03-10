package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayDemoApplication.class, args);
	}
}
