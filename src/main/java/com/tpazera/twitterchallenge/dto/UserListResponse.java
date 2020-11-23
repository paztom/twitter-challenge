package com.tpazera.twitterchallenge.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="User List Response", description="Container for user list response")
public class UserListResponse {

	private List<UserDto> users;

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
}
