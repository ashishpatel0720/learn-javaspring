package com.db.frontrunner.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @RequestMapping("/topics")
    public List<Topic> getTopics(){
        return Arrays.asList(
           new Topic(),
           new Topic(),
           new Topic(),
           new Topic(),
           new Topic(),
           new Topic()
        );
    }

}
