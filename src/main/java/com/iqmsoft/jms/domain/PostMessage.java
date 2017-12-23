package com.iqmsoft.jms.domain;

import org.springframework.web.bind.annotation.ModelAttribute;



public class PostMessage {

    private String text;

    public PostMessage() {
    }

    public PostMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "PostMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}
