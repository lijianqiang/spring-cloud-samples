package com.springcloud.eureka.feign;

import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(Integer a, Integer b) {
        
        return -1;
    }

}
