package com.springcloud.eureka.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.eureka.feign.ComputeClient;
import com.springcloud.eureka.service.RemoteService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private static Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ComputeClient computeClient;
    
    @Autowired
    private RemoteService remoteService;

    @RequestMapping
    public String actionIndex(HttpServletRequest request) {
        LOG.info("actionIndex");

        return "/compute";
    }

    @RequestMapping(value = "/compute", method = RequestMethod.GET)
    public String actionCompute(HttpServletRequest request) {
        int a = strToInt(request.getParameter("a"));
        int b = strToInt(request.getParameter("b"));
        LOG.info("actionCompute:a={},b={}", a, b);
        int res = computeClient.add(a, b);
        return "add result: " + res;
    }
    
    @RequestMapping(value = "/compute2", method = RequestMethod.GET)
    public String actionCompute2(HttpServletRequest request) {
        int a = strToInt(request.getParameter("a"));
        int b = strToInt(request.getParameter("b"));
        LOG.info("actionCompute:a={},b={}", a, b);
        int res = remoteService.getResult(a, b);
        return "add result: " + res;
    }

    private int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int res = 0;
        try {
            res = Integer.valueOf(str);
        } catch (NumberFormatException nfe) {
            res = 0;
        }

        return res;
    }

}
