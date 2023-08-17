package com.hexagonal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hexagonal.adapter.drivern.MessageDto;
import com.hexagonal.adapter.drivern.MessageMapper;
import com.hexagonal.application.model.Message;
import com.hexagonal.application.port.in.CreateMessage;
import com.hexagonal.application.port.in.FindMessage;
import com.hexagonal.application.port.out.ReadMessage;
import com.hexagonal.application.port.out.WriteMessage;

@Service
public class MessageService implements CreateMessage, FindMessage {

    private final ReadMessage readMessage;
    private final WriteMessage writeMessage;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(ReadMessage readMessage, WriteMessage writeMessage, MessageMapper messageMapper) {
        this.readMessage = readMessage;
        this.writeMessage = writeMessage;
        this.messageMapper = messageMapper;
    }

    @Override
    public List<MessageDto> getAllMessages() {
        List<Message> messages = readMessage.findAll();
        return messages.stream()
                .map(messageMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto createMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        Message savedMessage = writeMessage.save(message);

        return messageMapper.mapToDto(savedMessage);
    }
}