package com.springcloud.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.eureka.feign.ComputeClient;

@Service("remoteService")
public class RemoteServiceImpl implements RemoteService {

    @Autowired
    private ComputeClient computeClient;

    @Override
    public int getResult(int a, int b) {
        return computeClient.add(a, b);
    }
}
