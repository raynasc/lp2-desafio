package com.helloworld.controller.request;

import com.helloworld.model.entities.Client;
import lombok.Setter;

@Setter
public class ClientRequest {
    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    public Client toClient(){

        var client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setEnabled(enabled);

        return client;
    }
}
