package com.professional.micromaster.firebasechat.addcontact.event;

public class AddContactEvent {
    boolean error  = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
