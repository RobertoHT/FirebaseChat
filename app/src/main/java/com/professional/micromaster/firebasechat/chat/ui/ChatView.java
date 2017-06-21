package com.professional.micromaster.firebasechat.chat.ui;

import com.professional.micromaster.firebasechat.entities.ChatMessage;

public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
