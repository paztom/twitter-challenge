package com.tpazera.twitterchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpazera.twitterchallenge.dto.FollowUserRequest;
import com.tpazera.twitterchallenge.dto.UserDto;
import com.tpazera.twitterchallenge.dto.UserListResponse;
import com.tpazera.twitterchallenge.services.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/twitterchallenge/users")
@Api(produces = "application/json", value = "Operations on users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	/**
	 * Get list of all the users
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "Get list of all the users", response = UserDto.class)
	public UserListResponse getAllUsers() {
		UserListResponse userListResponse = new UserListResponse();
		userListResponse.setUsers(usersService.getAllUsers());
		return userListResponse;
	}
	
	/**
	 * Follow the user
	 * @param followUserRequest
	 */
	@PostMapping("/follow")
	@ApiOperation(value = "Follow the user", response = UserDto.class)
	public void followUser(@RequestBody FollowUserRequest followUserRequest) {
		usersService.followUser(followUserRequest.getCurrentUser(), followUserRequest.getUserToFollow());
	}
	
}
