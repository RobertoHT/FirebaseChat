package com.professional.micromaster.firebasechat.chat;

public interface ChatInteractor {
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void destroyChatListener();
    void subscribeForChatUpdates();
    void unsubscribeForChatUpdates();
}
