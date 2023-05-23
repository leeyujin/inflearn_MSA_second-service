package com.example.secondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8082/welcome # zuul
// http://localhost:8082/second-service/welcome # spring cloud gateway
@RestController
//@RequestMapping("/")
@RequestMapping("/second-service")
@Slf4j
public class SecondServiceController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Second service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request")String header){
        log.info(header);
        return "Hello World in Second Service.";
    }

    @GetMapping("/check")
    public String check(){
        return "Hi, there. This is a message from Second service.";
    }
}
