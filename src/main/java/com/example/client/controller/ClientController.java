package com.example.client.controller;

import com.example.client.dto.ClientDTO;
import com.example.client.merchant.MerchantClient;
import com.example.client.merchant.MerchantDTO;
import com.example.client.service.ClientService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Validated
@RequiredArgsConstructor
@RequestMapping ("/api/client")
@RestController 
public class ClientController {

    private final ClientService clientService;
    private final MerchantClient merchantClient;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody ClientDTO dto) {
        clientService.saveClient(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody ClientDTO dto){
        clientService.updateClient(dto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestParam String id, @RequestParam String nif){
        clientService.deleteClient(id, nif);
    }

    @GetMapping("/findAll")
    public List<ClientDTO> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public Object findById(@RequestParam String id, @RequestParam String nif) {
        return clientService.findById(id, nif);
    }

    @GetMapping("/findByName/{name}")
    public List<ClientDTO> findByName(@PathVariable String name){
        return clientService.findByName(name);
    }

    @GetMapping("/findByEmail/{email}")
    public List<ClientDTO> findByEmail(@PathVariable String email){
        return clientService.findByEmail(email);
    }

    @GetMapping("/merchant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MerchantDTO> findMerchant(@RequestParam String id, @RequestParam String address) {
        return merchantClient.findById(id, address);
    }
}
