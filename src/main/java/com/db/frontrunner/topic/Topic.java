package com.db.frontrunner.topic;

public class Topic {

    static int idGenerator;
    String id;
    String desc;
    String title;


    public Topic() {
        this("desc"+Math.random(),"title"+Math.random());
    }

    public Topic(String desc, String title) {
        this.id = "t"+(++idGenerator);
        this.desc = desc;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;

    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                '}';
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
