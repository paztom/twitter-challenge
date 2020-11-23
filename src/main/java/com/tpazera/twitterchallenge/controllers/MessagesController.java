package com.tpazera.twitterchallenge.controllers;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpazera.twitterchallenge.dto.MessageDto;
import com.tpazera.twitterchallenge.dto.MessageListResponse;
import com.tpazera.twitterchallenge.services.MessagesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/twitterchallenge/messages")
@Api(produces = "application/json", value = "Operations on messages")
public class MessagesController {

	@Autowired
	private MessagesService messagesService;

	@PostMapping
	@ApiOperation(value = "Get list of all the users", response = MessageDto.class)
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Message successfully created"),
        @ApiResponse(code = 400, message = "Bad Request")
	})
	public MessageDto addMessage(@RequestBody MessageDto messageDto) throws BadAttributeValueExpException {
		if(messageDto.getValue().length()>140) {
			throw new BadAttributeValueExpException("Message value shouldn't be longer then 140 characters.");
		}
		return messagesService.addMessage(messageDto);
	}

	@GetMapping
	@ApiOperation(value = "Get list of all system messages", response = MessageListResponse.class)
	public MessageListResponse getAllMessages() {
		return new MessageListResponse().with(messagesService.getAllMessages());
	}

	@GetMapping("/wall/{userName}")
	@ApiOperation(value = "Get list of all user messages", response = MessageListResponse.class)
	public MessageListResponse findMessagesByUser(@PathVariable String userName) {
		return new MessageListResponse().with(messagesService.getUserMessages(userName));
	}

	@GetMapping("/timeline/{userName}")
	@ApiOperation(value = "Show all messages from followed users", response = MessageListResponse.class)
	public MessageListResponse getWall(@PathVariable String userName) {
		return new MessageListResponse().with(messagesService.getUserWall(userName));
	}
}
