package com.example.client.controller;

import com.example.client.dto.ClientDTO;
import com.example.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody ClientDTO dto) {

        clientService.saveClient(dto);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO getAllClients(@PathVariable String id) {
        return clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }

}
