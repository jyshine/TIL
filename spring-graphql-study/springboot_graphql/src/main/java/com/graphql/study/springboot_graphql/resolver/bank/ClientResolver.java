package com.graphql.study.springboot_graphql.resolver.bank;

import com.graphql.study.springboot_graphql.domain.bank.BankAccount;
import com.graphql.study.springboot_graphql.domain.bank.Client;
import graphql.GraphQLException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public DataFetcherResult<Client> client(BankAccount bankAccount){
        log.info("Requesting client data for bank account id {} ", bankAccount.getId());

//        return Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("clientResolve")
//                .lastName("client")
//                .build();

//        throw new GraphQLException("client unavailavle");

        /**
         * DATA FETCHER RESULT
         * 1: CALL MULTIPLE SERVICES
         * 2: CALL ANOTHER GRAPHQL SERVER
         * 3: CALL SERVICE THAT RETURNS PARTIAL RESPONSES
         */

//        throw new RuntimeException("sql select*~~~");

        return DataFetcherResult.<Client>newResult()
                .data(Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Data Fetcher")
                        .lastName("Result")
                        .build())
                .error(new GenericGraphQLError("Could not get sub-client id"))
                .build();
    }


}
