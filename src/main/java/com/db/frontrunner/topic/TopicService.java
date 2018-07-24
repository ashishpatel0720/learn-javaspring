package com.db.frontrunner.topic;

import com.db.frontrunner.response.Response;
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
    //we have to wrap that around ArrayList<> because that was immutable
    // so wehave to make it mutable.


    public List<Topic> getAllTopics()
    {
        return this.topics;
    }


    public Object getTopic(String id) {
        for(Topic t:topics){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return new Response(404,"not found","Topic is not found");
    }

    public Object addTopic(Topic topic) {

        return this.topics.add(topic)? topic:
                new Response(1,"Error","Can't add to the list");

    }

    public Object editTopic(Topic topic,String id) {
        for(int i=0;i<topics.size();i++){
            Topic temp=topics.get(i);

            if(temp.getId().equals(topic.id) &&  id.equals(topic.id)){
             //id which is passed through url and of topic which is passed should be same.
                topics.set(i,topic);
                return topics.get(i);
            }
        }

        return new Response(1,"not found","Topic not for editing found");


    }
}
