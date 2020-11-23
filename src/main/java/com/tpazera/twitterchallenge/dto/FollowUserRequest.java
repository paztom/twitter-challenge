package com.tpazera.twitterchallenge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="FollowUserRequest", description="Model for follow user request")
public class FollowUserRequest {

	private String currentUser;
	
	private String userToFollow;

	@ApiModelProperty(value = "Follower userName")
	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	@ApiModelProperty(value = "User which followet wants to follow")
	public String getUserToFollow() {
		return userToFollow;
	}

	public void setUserToFollow(String userToFollow) {
		this.userToFollow = userToFollow;
	}
	
}
