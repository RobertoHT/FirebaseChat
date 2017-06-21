package com.professional.micromaster.firebasechat.addcontact;

public class AddContactInteractorImpl implements AddContactInteractor {
    private AddContactRepositoryImpl repository;

    public AddContactInteractorImpl(AddContactRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void addContact(String email) {
        repository.addContact(email);
    }
}
