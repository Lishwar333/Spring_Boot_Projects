package com.hexagonal.application.port.out;

import java.util.List;

import com.hexagonal.application.model.Message;

public interface ReadMessage {
    Message findById(Long id);
    List<Message> findAll();
}