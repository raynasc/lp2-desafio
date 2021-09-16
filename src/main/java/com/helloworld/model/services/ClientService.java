package com.helloworld.model.services;

import com.helloworld.model.entities.Client;
import com.helloworld.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(Client client){

        if(repository.existsByEmail(client.getEmail())){
            throw new RuntimeException("Email já existe");
        }

        return repository.save(client);
    }

    public Client update(String id, Client client){
        var clientDataBase = this.getById(id);

            var c = repository.findByEmail(client.getEmail());

            if(c != null && !c.getId().equals(id)){
                throw new RuntimeException("Email já existe");
            }

            clientDataBase.setName(client.getName());
            clientDataBase.setEmail(client.getEmail());
            clientDataBase.setPassword(client.getPassword());
            clientDataBase.setEnabled(client.getEnabled());

           return repository.save(clientDataBase);
    }

    public Page<Client> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Client getById(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Client não existe"));
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
