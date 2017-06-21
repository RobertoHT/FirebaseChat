package com.professional.micromaster.firebasechat.entities;

import com.google.firebase.database.Exclude;

public class ChatMessage {
    private String msg;
    private String sender;
    @Exclude
    boolean sendByMe;

    public ChatMessage() {}

    public ChatMessage(String sender, String msg) {
        this.msg = msg;
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSendByMe() {
        return sendByMe;
    }

    public void setSendByMe(boolean sendByMe) {
        this.sendByMe = sendByMe;
    }
}
