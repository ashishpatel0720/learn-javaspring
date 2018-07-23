package com.db.frontrunner.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//this is service and a singleton object will be made ot
@Service
public class TopicService {

    private List<Topic>topics=new ArrayList<>(Arrays.asList(
            new Topic(),
            new Topic()
            ));


    public List<Topic> getAllTopics()
    {
        return this.topics;
    }


    public Topic getTopic(String id) {
        for(Topic t:topics){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return new Topic("not found","404 ERROR");
    }

    public Topic addTopic(Topic topic) {

        this.topics.add(topic);

        return topic;


    }
}
