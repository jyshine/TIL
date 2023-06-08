package com.example.springservicelayereventsourcing.evnets;

import com.example.springservicelayereventsourcing.entity.Users;

public record UserCreatedEvent(Users user) {
}
