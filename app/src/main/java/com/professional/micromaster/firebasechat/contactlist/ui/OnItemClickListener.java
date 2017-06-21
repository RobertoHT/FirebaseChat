package com.professional.micromaster.firebasechat.contactlist.ui;

import com.professional.micromaster.firebasechat.entities.User;

public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
