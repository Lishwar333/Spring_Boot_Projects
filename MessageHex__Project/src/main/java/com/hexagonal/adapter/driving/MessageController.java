package com.hexagonal.adapter.driving;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.hexagonal.adapter.drivern.MessageDto;
import com.hexagonal.application.model.Message;
import com.hexagonal.application.port.in.CreateMessage;
import com.hexagonal.application.port.in.FindMessage;
import com.hexagonal.service.MessageService;


@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getAllMessages() {
        List<MessageDto> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @PostMapping
    public ResponseEntity<MessageDto> createMessage(@RequestBody String content) {
        MessageDto message = messageService.createMessage(content);
        return ResponseEntity.ok(message);
    }
}
