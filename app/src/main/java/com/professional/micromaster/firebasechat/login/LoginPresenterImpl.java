package com.professional.micromaster.firebasechat.login;

import com.professional.micromaster.firebasechat.lib.Eventbus;
import com.professional.micromaster.firebasechat.lib.GreenRobotEventbus;
import com.professional.micromaster.firebasechat.login.event.LoginEvent;
import com.professional.micromaster.firebasechat.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {
    Eventbus eventbus;
    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.eventbus = GreenRobotEventbus.getInstance();
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventbus.register(this);
    }

    @Override
    public void onDestroy() {
        eventbus.unregister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.checkAlreadyAuthenticated();
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMesage());
                break;
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMesage());
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;
        }
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.singIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.singUp(email, password);
    }

    private void onSignInSuccess() {
        if (loginView != null){
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess() {
        if (loginView != null) {
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onFailedToRecoverSession() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
        }
    }
}
