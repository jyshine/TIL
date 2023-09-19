package com.graphql.study.springboot_graphql.resolver.bank.query;

import com.graphql.study.springboot_graphql.domain.bank.BankAccount;
import com.graphql.study.springboot_graphql.domain.bank.Client;
import com.graphql.study.springboot_graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id){
      log.info("Retrieving bank account id: {}", id);

//        var clientA = Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Philip")
//                .lastName("starritt1")
//                .build();
//        var clientB = Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Philip")
//                .lastName("starritt2")
//                .build();
//
//        clientA.setClient(clientB);
//        clientB.setClient(clientA);


        return BankAccount.builder()
                .id(id)
                .currency(Currency.KOR)
//                .client(clientA)
                .build();

    }

}
