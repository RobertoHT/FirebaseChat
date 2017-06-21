package com.professional.micromaster.firebasechat.contactlist;

public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {
    ContactListRepository contactListRepository;

    public ContactListSessionInteractorImpl() {
        contactListRepository = new ContactListRepositoryImpl();
    }

    @Override
    public void signOff() {
        contactListRepository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return contactListRepository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        contactListRepository.changeUserConnectionStatus(online);
    }
}
