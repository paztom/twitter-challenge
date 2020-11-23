package com.tpazera.twitterchallenge.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Message", description="Represents single message")
public class MessageDto {

    private Integer id;
    private String userName;
    private String title;
    private String value;
    private Date creationDate;

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
