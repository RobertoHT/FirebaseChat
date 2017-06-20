package com.professional.micromaster.firebasechat.lib;

public interface Eventbus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
