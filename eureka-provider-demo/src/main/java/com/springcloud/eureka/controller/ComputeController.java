package com.springcloud.eureka.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compute")
public class ComputeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComputeController.class);
	
    @Autowired
    private DiscoveryClient client;
    
    @RequestMapping
    public List<String> actionIndex( ) {
        ServiceInstance instance = client.getLocalServiceInstance();
        LOG.info("/, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        List<String> actions = new ArrayList<String>(2);
        actions.add("/");
        actions.add("/add?a=x&b=y");
        return actions;
    }
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        LOG.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

}
