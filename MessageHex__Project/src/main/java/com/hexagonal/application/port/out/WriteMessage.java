package com.hexagonal.application.port.out;

import com.hexagonal.application.model.Message;

public interface WriteMessage {
    Message save(Message message);
}