package com.helloworld.controller;

import com.helloworld.controller.request.ClientRequest;
import com.helloworld.controller.response.ClientResponse;
import com.helloworld.model.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private  ClientService service;

    @PostMapping
    public ClientResponse post(@RequestBody ClientRequest clientRequest){

        var client = clientRequest.toClient();

        return new ClientResponse().fromClient(service.create(client));
    }

    @PutMapping("{id}")
    public ClientResponse put(@PathVariable String id, @RequestBody ClientRequest clientRequest){

        var client = clientRequest.toClient();

        return new ClientResponse().fromClient( service.update(id,client));

    }

    @GetMapping("{id}")
    public ClientResponse getById(@PathVariable String id){

        return new ClientResponse().fromClient(service.getById(id));
    }

    @GetMapping
    public Page<ClientResponse> get(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int linesPerPage,@RequestParam(defaultValue = "ASC") String direction,@RequestParam(defaultValue = "name") String orderBy ){

        var pageable =  PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);

        return service.getAll(pageable)
                .map(c-> new ClientResponse().fromClient(c));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }


}
