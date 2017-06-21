package com.professional.micromaster.firebasechat.contactlist;

public class ContactListInteractorImpl implements ContactListInteractor {
    ContactListRepository repository;

    public ContactListInteractorImpl() {
        repository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribeForContactEvents() {
        repository.subscribeForContactListUpdates();
    }

    @Override
    public void unsubscribeForContactEvents() {
        repository.unsubscribeForContactListUpdates();
    }

    @Override
    public void destroyContactListListener() {
        repository.destroyContactListListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}
