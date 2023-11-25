package com.apigateway.demo.RestService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@RestController
public class Test {

    private WebClient webClient;

    public Test(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.baseUrl("http://localhost:9090/").build();
    }


    @GetMapping("/test")
    public Mono<String> testConnectivity(){
        Mono<String> value= webClient.get().uri("/testConnectivity").retrieve().bodyToMono(String.class);
        return  value;
    }
}
