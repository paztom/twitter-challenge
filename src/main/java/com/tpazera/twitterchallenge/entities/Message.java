package com.tpazera.twitterchallenge.entities;

import java.util.Date;

public class Message {

    private Integer id;
    private String userName;
    private String title;
    private String value;
    private Date creationDate;

    public Message() {
        super();
    }

    public Message(Integer id, String userName, String title, String value, Date creationDate) {
        super();
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.value = value;
        this.creationDate = creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
