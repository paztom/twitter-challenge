package com.tpazera.twitterchallenge.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Message List Response", description="Container for message list response")
public class MessageListResponse {

	private List<MessageDto> messages;

	public List<MessageDto> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDto> messages) {
		this.messages = messages;
	}
	
	public MessageListResponse with(List<MessageDto> messages) {
		setMessages(messages);
		return this;
	}

}
