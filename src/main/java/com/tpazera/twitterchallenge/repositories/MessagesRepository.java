package com.tpazera.twitterchallenge.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.tpazera.twitterchallenge.entities.Message;
import com.tpazera.twitterchallenge.entities.User;

@Repository
public class MessagesRepository {

    private List<Message> messages;
    
    {
        messages = Collections.synchronizedList(new ArrayList());
        messages.add(new Message(1, "tpazera", "Message 1 title", "This is message 1", new Date()));
        messages.add(new Message(2, "tpazera", "Message 2 title", "This is message 2", new Date()));
        messages.add(new Message(3, "jnowak", "Message 3 title", "This is message 3", new Date()));
    }

    public Message addMessage(Message message) {
    	Integer lastIndex = messages.stream().map(Message::getId).max(Integer::compareTo).get();
        message.setId(lastIndex + 1);
        messages.add(message);
        return message;
    }

    public Message getMessage(Integer id) {
        Message message = messages.stream().filter(m -> m.getId().equals(id)).findFirst().get();
        return message;
    }

    public List<Message> findMessagesByUser(String username) {
        List<Message> userMessages =
            messages.stream().filter(m -> m.getUserName().equals(username)).collect(Collectors.toList());
        return userMessages;
    }
    
    public List<Message> findMessagesByUsers(List<String> users) {
        List<Message> userMessages =
            messages.stream().filter(m -> users.contains(m.getUserName())).collect(Collectors.toList());
        return userMessages;
    }
    
    public List<Message> findAllMessages() {
        return messages;
    }
}
