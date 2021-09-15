package com.helloworld.model.repository;

import com.helloworld.model.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,String> {

    boolean existsByName(String name);
    Client findByName(String name);
}
