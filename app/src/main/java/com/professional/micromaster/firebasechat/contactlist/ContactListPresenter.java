package com.professional.micromaster.firebasechat.contactlist;

import com.professional.micromaster.firebasechat.contactlist.event.ContactListEvent;

public interface ContactListPresenter {
    void onCreate();
    void onResume();
    void onPause();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
