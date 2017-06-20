package com.professional.micromaster.firebasechat.login;

public interface LoginInteractor {
    void singUp(String email, String password);
    void singIn(String email, String password);
    void checkAlreadyAuthenticated();
}
