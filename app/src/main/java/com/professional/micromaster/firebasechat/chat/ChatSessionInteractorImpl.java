package com.professional.micromaster.firebasechat.chat;

public class ChatSessionInteractorImpl implements ChatSessionInteractor {
    private ChatRepository chatRepository;

    public ChatSessionInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void changeUserConnectionStatus(boolean online) {
        chatRepository.changeUserConnectionStatus(online);
    }
}
