package com.professional.micromaster.firebasechat.contactlist;

public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
