package com.professional.micromaster.firebasechat.chat.event;

import com.professional.micromaster.firebasechat.entities.ChatMessage;

public class ChatEvent {
    private ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
