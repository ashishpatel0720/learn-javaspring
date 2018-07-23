package com.db.frontrunner.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicsController {

    /*
    we have to tell spring that this thing need to get
     dependency injection from spring, this is done by @Autowired
     */
    @Autowired
    private TopicService topicService;
    //now only one instance of TopicService will be shared everywhere


    @RequestMapping(value="/topics")
    public List<Topic> getTopics(){
        return this.topicService.getAllTopics();
    }


    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        //we have to tell spring that {id} coming is being passed as argument
    // OR    public Topic getTopic(@PathVariable("id") String id){
    //  if both names are not same

        return topicService.getTopic(id);
    }

    @RequestMapping("*")
    public String fallBack(){
        return "Fallback method";
    }
}
