package com.tpazera.twitterchallenge.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="User", description="Represents single user")
public class UserDto {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
