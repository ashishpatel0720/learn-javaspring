package com.db.frontrunner.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

//GET Requests

    @RequestMapping(value="/topics", method=RequestMethod.GET)
    //if we haven't given 'method', it will handle all type of requests
    public List<Topic> getTopics(){
        return this.topicService.getAllTopics();
    }


    @RequestMapping(value = "/topics/{id}",method = RequestMethod.GET)
    public Topic getTopic(@PathVariable String id){
        //we have to tell spring that {id} coming is being passed as argument
    // OR    public Topic getTopic(@PathVariable("id") String id){
    //  if both names are not same

        return topicService.getTopic(id);
    }


    @RequestMapping(value = "*",method = RequestMethod.GET)
    public String fallBack(){
        return "Fallback method";
    }


}
