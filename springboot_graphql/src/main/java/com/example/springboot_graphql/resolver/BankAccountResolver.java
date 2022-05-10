package com.example.springboot_graphql.resolver;

import com.example.springboot_graphql.domain.bank.BankAccount;
import com.example.springboot_graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id){
      log.info("Retrieving bank account id: {}", id);
      return BankAccount.builder().id(id).currency(Currency.KOR).name("june").build();
    }

}
