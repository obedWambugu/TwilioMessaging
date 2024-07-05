package org.example.service;

import org.example.entity.MyMessage;
import org.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MyMessage createMessage(MyMessage message){
        return messageRepository.save(message);
    }
}
