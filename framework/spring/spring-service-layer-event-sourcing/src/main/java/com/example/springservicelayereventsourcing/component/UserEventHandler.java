package com.example.springservicelayereventsourcing.component;

import com.example.springservicelayereventsourcing.evnets.UserCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event){

        System.out.println(event.user().getId());
        System.out.println(event.user().getUserName());
    }
}
