package com.apigateway.demo.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="BACKEND-DB")
public interface TestConnectivity {

    @GetMapping("/testConnectivity")
    public String test();

}
