package com.hexagonal.adapter.drivern;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hexagonal.application.model.Message;
import com.hexagonal.application.port.in.CreateMessage;
import com.hexagonal.application.port.in.FindMessage;
import com.hexagonal.application.port.out.ReadMessage;
import com.hexagonal.application.port.out.WriteMessage;


@Component
public class MessageAdapter implements ReadMessage, WriteMessage {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageAdapter(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}

