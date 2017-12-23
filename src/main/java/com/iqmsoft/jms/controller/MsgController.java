package com.iqmsoft.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iqmsoft.jms.domain.MessageDTO;
import com.iqmsoft.jms.domain.PostMessage;
import com.iqmsoft.jms.handlers.Producer;
import com.iqmsoft.jms.service.MsgService;

import java.util.List;


@Controller
public class MsgController {

    @Autowired
    private MsgService messageService;

    @Autowired
    private Producer producer;

    @ModelAttribute(name="messages")
    public List<MessageDTO> getMessages() {
        return messageService.getMessages();
    }

    @ModelAttribute(name="numMessages")
    public int getMessagesSize() {
        return messageService.getNumMessage();
    }

    @GetMapping(value = {"/","/message"})
    public String messageForm(Model model) {
        model.addAttribute("postMessage", new PostMessage());
        return "postMessage";
    }

    @PostMapping(value = "/message")
    public String sendMessage(@ModelAttribute PostMessage msg) {
        System.out.println("Should send text.");
        System.out.println(msg);
        producer.send(msg.getText());
        return "postMessage";
    }

}
