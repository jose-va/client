package com.example.client.controller;

import com.example.client.dto.ClientDTO;
import com.example.client.service.ClientService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
@RequestMapping ("/api/clients")
@RestController
public class ClientController {

    private final ClientService clientService;

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

    @GetMapping("/email")
    public Optional<ClientDTO> findByEmail(@Pattern(regexp = "^[a-z]+\\.[a-z]+@petroprix.com$") @RequestParam String email){
        return clientService.findByEmail(email);
    }

    @GetMapping("/name")
    public List<ClientDTO> findByName(@RequestParam String name){
        return clientService.findByName(name);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody ClientDTO dto, @PathVariable String id){
        clientService.updateClient(dto, id);
    }
}
