package com.tpazera.twitterchallenge.mappers;

import org.mapstruct.Mapper;

import com.tpazera.twitterchallenge.dto.MessageDto;
import com.tpazera.twitterchallenge.entities.Message;

@Mapper(componentModel = "spring")
public abstract class MessageMapper {

    public abstract MessageDto mapFromEntityToDto(Message message);

    public abstract Message mapMessageDtoToMessageEntity(MessageDto messageDto);
}
