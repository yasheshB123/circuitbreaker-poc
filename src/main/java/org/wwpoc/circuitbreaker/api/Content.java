package org.wwpoc.circuitbreaker.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wwpoc.circuitbreaker.service.ContentService;

@RestController
public class Content {

    @Autowired
    ContentService service;

    @GetMapping("/content")
    @HystrixCommand(fallbackMethod = "fallback")
    String getContent(){
        return service.content();
    }


    String fallback(){
        return "fallback";
    }

}
