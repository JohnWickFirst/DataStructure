package com.apigateway.demo.RestService;

import com.apigateway.demo.Enum.ServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest")
public class DbBackend {



    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String testConnectivity(){
        String value= restTemplate.getForObject
                (ServiceEnum.Header.getServiceName()+ServiceEnum.BackEndDb +"testConnectivity",String.class);
        return  value;
    }

    @GetMapping("/demo")
    public String demo(){
        return "DEMO";
    }




}
