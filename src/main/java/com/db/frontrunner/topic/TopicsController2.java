package com.db.frontrunner.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicsController2 {

    /*
    we have to tell spring that this thing need to get
     dependency injection from spring, this is done by @Autowired
     */
    @Autowired
    private TopicService ts;
    //now only one instance of TopicService will be shared everywhere


    @RequestMapping("/topics2")
    public List<Topic> getTopics(){
            return this.ts.getAllTopics();
        }

}
