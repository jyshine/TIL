package com.graphql.study.springboot_graphql.domain.bank;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

import java.util.UUID;

@Builder
@Setter
public class Client {
    UUID id;
    String firstName;
    String[] middleNames;
    String lastName;

    Client client;

}
