package com.professional.micromaster.firebasechat.chat;

public class ChatInteractorImpl implements ChatInteractor {
    private ChatRepository chatRepository;

    public ChatInteractorImpl() {
        chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void subscribeForChatUpdates() {
        chatRepository.subscribeForChatUpdates();
    }

    @Override
    public void unsubscribeForChatUpdates() {
        chatRepository.unsubscribeForChatUpdates();
    }
}
