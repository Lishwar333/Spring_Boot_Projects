package com.hexagonal.application.port.in;

import com.hexagonal.adapter.drivern.MessageDto;

public interface CreateMessage {
	MessageDto createMessage(String content);
}