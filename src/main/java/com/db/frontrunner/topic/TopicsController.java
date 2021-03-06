package com.db.frontrunner.topic;

import com.db.frontrunner.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        try{
            return this.topicService.getAllTopics();
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
        return null;
    }


    @RequestMapping(value = "/topics/{id}",method = RequestMethod.GET)
    public Object getTopic(@PathVariable String id){
        //we have to tell spring that {id} coming is being passed as argument
        // OR    public Topic getTopic(@PathVariable("id") String id){
        //  if both names are not same

        return topicService.getTopic(id);
    }


    @RequestMapping(value = "*",method = RequestMethod.GET)
    public Response fallBack(){
        return
                new Response(501,"Not Implemented",
                        " hih this path is  not available");
    }

    //POST Requests
    /* use CURL command like this
     curl -X POST \
         http://localhost:7777/topics \
         -H 'Cache-Control: no-cache' \
         -H 'Content-Type: application/json' \
         -H 'Postman-Token: aefcbafe-68d6-4da2-b9b5-99cb99537f21' \
         -d '{
                "desc": "desc0.3261299886898633",
                "title": "title0.8004074373549455"}'
     */

    //third value will be automatically created as there is only constructor for 2 values
    @RequestMapping(value = "/topics",method = RequestMethod.POST)
    //we have to tell java that 'request body' needed to be converted into Topic
    //object using dependency injection, for this we use @RequestBody
    public Object addTopic(@RequestBody Topic topic){
        return topicService.addTopic(topic);
    }

    @RequestMapping(value ="/topics/{id}",method = RequestMethod.PATCH)
    public Object editTopic(@RequestBody Topic topic, @PathVariable String id){
        return topicService.editTopic(topic,id);
    }


    @RequestMapping(value = "/topics/{id}",method = RequestMethod.DELETE)
    public Object deleteTopic(@PathVariable String id){
        return topicService.deleteTopic(id);
    }
}

