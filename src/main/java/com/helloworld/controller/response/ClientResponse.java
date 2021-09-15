package com.helloworld.controller.response;

import com.helloworld.model.entities.Client;
import lombok.Getter;

@Getter
public class ClientResponse {

    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    public ClientResponse fromClient(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.enabled = client.getEnabled();
        return this;
    }
}
