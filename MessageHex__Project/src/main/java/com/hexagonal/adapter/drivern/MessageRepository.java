package com.hexagonal.adapter.drivern;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.application.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}