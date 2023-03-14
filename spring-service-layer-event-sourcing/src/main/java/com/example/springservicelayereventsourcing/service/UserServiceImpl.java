package com.example.springservicelayereventsourcing.service;

import com.example.springservicelayereventsourcing.entity.Users;
import com.example.springservicelayereventsourcing.evnets.UserCreatedEvent;
import com.example.springservicelayereventsourcing.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final ApplicationEventPublisher eventPublisher;
    UserRepository userRepository = new UserRepository();

    public UserServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void createUser(Users user) {
        Users u = userRepository.save(user);

        eventPublisher.publishEvent(new UserCreatedEvent(u));

    }
}
