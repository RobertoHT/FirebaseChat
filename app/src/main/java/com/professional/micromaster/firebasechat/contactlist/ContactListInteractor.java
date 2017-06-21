package com.professional.micromaster.firebasechat.contactlist;

public interface ContactListInteractor {
    void subscribeForContactEvents();
    void unsubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);
}
