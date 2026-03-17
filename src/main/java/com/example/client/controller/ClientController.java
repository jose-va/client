package com.example.client.controller;

import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/clients")
public class ClientController {

//    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @PostMapping
    public void createClient(@RequestBody Client client){
        clientRepository.save(client);
    }

}
