package com.db.frontrunner.hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //by default @RequestMapping maps for all http requests
    @RequestMapping("/hello")
    public String hello(){
        return "hi";
    }

}
