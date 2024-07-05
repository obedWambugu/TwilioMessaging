package org.example.service;

import org.example.entity.MyMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface MessageService {
    MyMessage createMessage(MyMessage message);
}
