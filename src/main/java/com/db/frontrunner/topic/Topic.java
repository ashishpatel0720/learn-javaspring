package com.db.frontrunner.topic;

public class Topic {

    static int idGenerator;
    int id;
    String desc;
    String title;


    public Topic() {
        this("desc"+Math.random(),"title"+Math.random());
    }

    public Topic(String desc, String title) {
        this.id = ++idGenerator;
        this.desc = desc;
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;

    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
