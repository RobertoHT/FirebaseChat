package com.professional.micromaster.firebasechat.contactlist;

import com.professional.micromaster.firebasechat.contactlist.event.ContactListEvent;
import com.professional.micromaster.firebasechat.contactlist.ui.ContactListView;
import com.professional.micromaster.firebasechat.entities.User;
import com.professional.micromaster.firebasechat.lib.Eventbus;
import com.professional.micromaster.firebasechat.lib.GreenRobotEventbus;

import org.greenrobot.eventbus.Subscribe;

public class ContactListPresenterImpl implements ContactListPresenter {
    private Eventbus eventbus;
    private ContactListView contactListView;
    private ContactListInteractor contactListInteractor;
    private ContactListSessionInteractor contactListSessionInteractor;

    public ContactListPresenterImpl(ContactListView contactListView) {
        this.eventbus = GreenRobotEventbus.getInstance();
        this.contactListView = contactListView;
        contactListInteractor = new ContactListInteractorImpl();
        contactListSessionInteractor = new ContactListSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventbus.register(this);
    }

    @Override
    public void onResume() {
        contactListInteractor.subscribeForContactEvents();
        contactListSessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onPause() {
        contactListInteractor.unsubscribeForContactEvents();
        contactListSessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onDestroy() {
        eventbus.unregister(this);
        contactListInteractor.destroyContactListListener();
        contactListView = null;
    }

    @Override
    public void signOff() {
        contactListSessionInteractor.changeConnectionStatus(User.OFFLINE);
        contactListInteractor.destroyContactListListener();
        contactListInteractor.unsubscribeForContactEvents();
        contactListSessionInteractor.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return contactListSessionInteractor.getCurrentUserEmail();
    }

    @Override
    public void removeContact(String email) {
        contactListInteractor.removeContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ContactListEvent event) {
        User user = event.getUser();
        switch (event.getEventType()) {
            case ContactListEvent.onContactAdded:
                onContactAdded(user);
                break;
            case ContactListEvent.onContactChanged:
                onContactChanged(user);
                break;
            case ContactListEvent.onContactRemoved:
                onContactRemoved(user);
                break;
        }
    }

    public void onContactAdded(User user) {
        if (contactListView != null) {
            contactListView.onContactAdded(user);
        }
    }

    public void onContactChanged(User user) {
        if (contactListView != null) {
            contactListView.onContactChanged(user);
        }
    }

    public void onContactRemoved(User user) {
        if (contactListView != null) {
            contactListView.onContactRemoved(user);
        }
    }
}
