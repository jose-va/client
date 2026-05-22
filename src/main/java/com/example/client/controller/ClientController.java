package com.example.client.controller;

import com.example.client.dto.ClientDTO;
import com.example.client.merchant.MerchantClient;
import com.example.client.dto.MerchantDTO;
import com.example.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Validated
@RequiredArgsConstructor
@RequestMapping("/api/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientDTO dto) {
        clientService.saveClient(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody ClientDTO dto) {
        clientService.updateClient(dto);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> findById(@PathVariable String id){
        return clientService.findById(id);
    }

    @GetMapping("/all")
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/search/name")
    public List<ClientDTO> findByName(@RequestParam String name) {
        return clientService.findByName(name);
    }

    @GetMapping("/search/email")
    public List<ClientDTO> findByEmail(@RequestParam String email) {
        return clientService.findByEmail(email);
    }

    @GetMapping("/search/merchant")
    public List<ClientDTO> findClientByMerchant(@RequestParam String merchantId) {
        return clientService.findByMerchant(merchantId);
    }

    @DeleteMapping("/delete/{id}/{nif}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable String id, @PathVariable String nif) {
        clientService.deleteClient(id, nif);
    }
}
