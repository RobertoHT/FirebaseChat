package com.professional.micromaster.firebasechat.contactlist.ui;

import com.professional.micromaster.firebasechat.entities.User;

public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
