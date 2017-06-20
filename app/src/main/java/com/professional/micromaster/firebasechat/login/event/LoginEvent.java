package com.professional.micromaster.firebasechat.login.event;

public class LoginEvent {
    public static final int onSignInError = 0;
    public static final int onSignUpError = 1;
    public static final int onSignInSuccess = 2;
    public static final int onSignUpSuccess = 3;
    public static final int onFailedToRecoverSession = 4;

    private int eventType;
    private String errorMesage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }
}
