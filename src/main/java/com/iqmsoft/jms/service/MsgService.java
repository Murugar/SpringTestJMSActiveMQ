package com.iqmsoft.jms.service;

import org.springframework.stereotype.Service;

import com.iqmsoft.jms.domain.MessageDTO;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

@Service
public class MsgService {

    private List<MessageDTO> messageList = new ArrayList<>();

    public void addMessage(MessageDTO messageInfo) {
        this.messageList.add(messageInfo);
    }

    public List<MessageDTO> getMessages() {
        ArrayList<MessageDTO> shallowCopy = new ArrayList<>(messageList);
        Collections.reverse(shallowCopy);
        return shallowCopy;
    }

    public int getNumMessage() {
        return messageList.size();
    }

}
