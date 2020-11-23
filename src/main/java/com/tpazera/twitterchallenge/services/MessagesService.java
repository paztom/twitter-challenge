package com.tpazera.twitterchallenge.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tpazera.twitterchallenge.dto.MessageDto;
import com.tpazera.twitterchallenge.dto.UserDto;
import com.tpazera.twitterchallenge.entities.Message;
import com.tpazera.twitterchallenge.mappers.MessageMapper;
import com.tpazera.twitterchallenge.repositories.MessagesRepository;

@Service
public class MessagesService {

	private MessagesRepository messagesRepository;

	private UsersService usersService;

	private final MessageMapper messageMapper;

	public MessagesService(MessagesRepository messagesRepository, MessageMapper messageMapper, UsersService usersService) {
		this.messagesRepository = messagesRepository;
		this.messageMapper = messageMapper;
		this.usersService = usersService;
	}

	public MessageDto addMessage(MessageDto messageDto) {
		Message message = messageMapper.mapMessageDtoToMessageEntity(messageDto);
		message.setCreationDate(new Date());
		message = messagesRepository.addMessage(message);
		messageDto.setId(message.getId());
		//Add user when doesn't exist
		UserDto userDto = new UserDto();
		userDto.setUserName(message.getUserName());
		usersService.addUser(userDto);
		return messageDto;
	}

	public List<MessageDto> getUserMessages(String username) {
		List<Message> messages = messagesRepository.findMessagesByUser(username);

		return messages.stream().map(messageMapper::mapFromEntityToDto).sorted(dateComparator)
				.collect(Collectors.toList());
	}

	public List<MessageDto> getAllMessages() {
		List<Message> messages = messagesRepository.findAllMessages();

		return messages.stream().map(messageMapper::mapFromEntityToDto).sorted(dateComparator)
				.collect(Collectors.toList());
	}

	public List<MessageDto> getUserWall(String userName) {
		List<UserDto> users = usersService.getAllFollowedUsers(userName);
		List<Message> messages = messagesRepository
				.findMessagesByUsers(users.stream().map(UserDto::getUserName).collect(Collectors.toList()));
		return messages.stream().map(messageMapper::mapFromEntityToDto).sorted(dateComparator)
				.collect(Collectors.toList());
	}

	Comparator<MessageDto> dateComparator = (arg1, arg2) -> {
		return arg2.getCreationDate().compareTo(arg1.getCreationDate());
	};

}
