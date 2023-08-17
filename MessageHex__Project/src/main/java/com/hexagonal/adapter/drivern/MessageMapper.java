package com.hexagonal.adapter.drivern;

import org.springframework.stereotype.Component;
import com.hexagonal.application.model.Message;

@Component
public class MessageMapper {

    public MessageDto mapToDto(Message message) {
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setContent(message.getContent());
        return dto;
    }
}


