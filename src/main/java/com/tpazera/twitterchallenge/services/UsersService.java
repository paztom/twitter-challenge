package com.tpazera.twitterchallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tpazera.twitterchallenge.dto.UserDto;
import com.tpazera.twitterchallenge.entities.User;
import com.tpazera.twitterchallenge.mappers.UserMapper;
import com.tpazera.twitterchallenge.repositories.UsersRepository;

@Service
public class UsersService {

	private UsersRepository usersRepository;

	private UserMapper userMapper;

	public UsersService(UsersRepository usersRepository, UserMapper userMapper) {
		this.usersRepository = usersRepository;
		this.userMapper = userMapper;
	}

	public List<UserDto> getAllUsers() {
		return usersRepository.findAllUsers().stream().map(userMapper::mapFromEntityToDto).collect(Collectors.toList());
	}

	public boolean followUser(String currentUser, String userToFollow) {
		Optional<User> userCurrent = usersRepository.findUserByUserName(currentUser);
		Optional<User> userFollow = usersRepository.findUserByUserName(userToFollow);
		if (userCurrent.isPresent() && userFollow.isPresent()) {
			userCurrent.get().getFollows().add(userFollow.get());
			usersRepository.updateUser(userCurrent.get());
			return true;
		}
		return false;
	}

	public UserDto getUserByUserName(String userName) {
		Optional<User> user = usersRepository.findUserByUserName(userName);
		if (user.isPresent()) {
			return userMapper.mapFromEntityToDto(user.get());
		}
		return null;
	}

	public List<UserDto> getAllFollowedUsers(String userName) {
		Optional<User> user = usersRepository.findUserByUserName(userName);
		if (user.isPresent()) {
			List<User> users = user.get().getFollows();
			return users.stream().map(userMapper::mapFromEntityToDto).collect(Collectors.toList());
		}
		return null;
	}

	public boolean addUser(UserDto userDto) {
		return usersRepository.addUser(userMapper.mapUserDtoToUserEntity(userDto));
	}

}
