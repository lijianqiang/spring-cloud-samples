package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springcloud.zuul.filter.AccessZuulFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayDemoApplication.class, args);
	}
	
	@Bean
	public AccessZuulFilter accessFilter() {
	    return new AccessZuulFilter();
	}
	
	
}
