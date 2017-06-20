package com.professional.micromaster.firebasechat.login;

import com.professional.micromaster.firebasechat.login.LoginInteractor;
import com.professional.micromaster.firebasechat.login.LoginRepository;
import com.professional.micromaster.firebasechat.login.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void singUp(String email, String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void singIn(String email, String password) {
        loginRepository.signIn(email, password);
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }
}
