package com.professional.micromaster.firebasechat.login;

import com.professional.micromaster.firebasechat.login.event.LoginEvent;

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
