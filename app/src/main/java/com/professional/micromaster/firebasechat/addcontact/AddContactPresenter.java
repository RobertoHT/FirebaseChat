package com.professional.micromaster.firebasechat.addcontact;

import com.professional.micromaster.firebasechat.addcontact.event.AddContactEvent;

public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
