package com.professional.micromaster.firebasechat.chat;

import com.professional.micromaster.firebasechat.chat.event.ChatEvent;
import com.professional.micromaster.firebasechat.chat.ui.ChatView;
import com.professional.micromaster.firebasechat.entities.ChatMessage;
import com.professional.micromaster.firebasechat.entities.User;
import com.professional.micromaster.firebasechat.lib.Eventbus;
import com.professional.micromaster.firebasechat.lib.GreenRobotEventbus;

import org.greenrobot.eventbus.Subscribe;

public class ChatPresenterImpl implements ChatPresenter {
    private Eventbus eventbus;
    private ChatView chatView;
    private ChatInteractor chatInteractor;
    private ChatSessionInteractor chatSessionInteractor;

    public ChatPresenterImpl(ChatView chatView) {
        this.eventbus = GreenRobotEventbus.getInstance();
        this.chatView = chatView;
        this.chatInteractor = new ChatInteractorImpl();
        this.chatSessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventbus.register(this);
    }

    @Override
    public void onPause() {
        chatInteractor.unsubscribeForChatUpdates();
        chatSessionInteractor.changeUserConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribeForChatUpdates();
        chatSessionInteractor.changeUserConnectionStatus(User.ONLINE);
    }

    @Override
    public void onDestroy() {
        eventbus.unregister(this);
        chatInteractor.destroyChatListener();
        chatView = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ChatEvent event) {
        if (chatView != null) {
            ChatMessage chatMessage = event.getMessage();
            chatView.onMessageReceived(chatMessage);
        }
    }
}
