package com.professional.micromaster.firebasechat.contactlist;

public interface ContactListRepository {
    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unsubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);
}
