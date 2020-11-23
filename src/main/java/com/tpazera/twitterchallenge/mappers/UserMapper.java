package com.tpazera.twitterchallenge.mappers;

import org.mapstruct.Mapper;

import com.tpazera.twitterchallenge.dto.UserDto;
import com.tpazera.twitterchallenge.entities.User;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

	public abstract UserDto mapFromEntityToDto(User user);

	public abstract User mapUserDtoToUserEntity(UserDto userDto);
}
