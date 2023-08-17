package com.hexagonal.application.port.in;

import java.util.List;

import com.hexagonal.adapter.drivern.MessageDto;

public interface FindMessage {
	List<MessageDto>  getAllMessages();
}