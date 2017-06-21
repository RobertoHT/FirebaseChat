package com.professional.micromaster.firebasechat.chat;

public interface ChatRepository {
    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpdates();
    void unsubscribeForChatUpdates();

    void changeUserConnectionStatus(boolean online);
}
