package com.iqmsoft.jms.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.iqmsoft.jms.domain.MessageDTO;
import com.iqmsoft.jms.service.MsgService;

import javax.jms.JMSException;
import javax.jms.Message;



@Component
public class Receiver {

    @Autowired
    private MsgService messageService;

    @JmsListener(destination = "TESTTOPIC", containerFactory = "myFactory")
    public void receiveMessage(Message msg) {
        MessageDTO currMsg = new MessageDTO(msg);
        messageService.addMessage(currMsg);
        System.out.println(currMsg);
        try {
            msg.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
