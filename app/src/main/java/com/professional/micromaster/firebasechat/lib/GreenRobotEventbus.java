package com.professional.micromaster.firebasechat.lib;

import org.greenrobot.eventbus.EventBus;

public class GreenRobotEventbus implements Eventbus {
    EventBus eventBus;

    private static class SingletonHolder {
        private static final GreenRobotEventbus INSTANCE = new GreenRobotEventbus();
    }

    public static GreenRobotEventbus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public GreenRobotEventbus() {
        eventBus = EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
