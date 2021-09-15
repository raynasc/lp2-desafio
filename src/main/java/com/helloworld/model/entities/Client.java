package com.helloworld.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    public boolean getEnabled() {
        return enabled;
    }
}
