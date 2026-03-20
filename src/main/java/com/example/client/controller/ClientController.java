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

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object findById(@PathVariable String id, @RequestParam String nif, @RequestParam boolean simpleOutput) {
        return clientService.findById(id, nif, simpleOutput);
    }

    @GetMapping("/merchant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MerchantDTO> findMerchant(@PathVariable String id, @RequestParam String address) {
        return merchantClient.findById(id, address);
    }

    @GetMapping("/findName")
    public List<ClientDTO> findByName(@RequestParam String name){
        return clientService.findByName(name);
    }

    @GetMapping("/findEmail")
    public List<ClientDTO> findByEmail(@Pattern(regexp = "^[a-z]+\\.[a-z]+@petroprix.com$") @RequestParam String email){
        return clientService.findByEmail(email);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@PathVariable String id, @RequestBody ClientDTO dto){
        clientService.updateClient(id, dto);
    }
}
