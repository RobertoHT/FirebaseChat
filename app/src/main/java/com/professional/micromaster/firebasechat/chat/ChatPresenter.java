package com.professional.micromaster.firebasechat.chat;

import com.professional.micromaster.firebasechat.chat.event.ChatEvent;

public interface ChatPresenter {
    void onCreate();
    void onPause();
    void onResume();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
