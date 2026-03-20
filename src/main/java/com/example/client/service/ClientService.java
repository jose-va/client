package com.example.client.service;

import com.example.client.dto.ClientDTO;
import com.example.client.mappers.ClientMapper;
import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void saveClient(ClientDTO dto) {
        Client client= clientMapper.toEntity(dto);

        client.setId(UUID.randomUUID().toString());
        client.setPk("CLIENT#" + client.getId());
        client.setSk("NIF#" + client.getCifNifNie());
        client.setGIndex2Pk("EMAIL#" + client.getEmail());

        clientRepository.save(client);
    }

    public void updateClient(String id, ClientDTO dto) {

        Client updateClient = clientMapper.toEntity(dto);

        updateClient.setId(id);
        updateClient.setPk("CLIENT#" + id);
        updateClient.setSk("NIF#" + updateClient.getCifNifNie());
        updateClient.setGIndex2Pk("EMAIL#" + updateClient.getEmail());

        clientRepository.save(updateClient);
    }

    public Object findById(String id, String nif, boolean simpleOutput) {

        String pk = "MERCHANT#" + id;
        String sk = "NIF#" + nif;

        Client client = clientRepository.findById(pk, sk);
        if (client == null) throw new RuntimeException("Cliente no encontrado");
        
        if (simpleOutput) return Map.of("id", client.getId());

        return clientMapper.toDto(client);
    }

    public List<ClientDTO> findByName(String name) {
        return clientRepository.findAll()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ClientDTO> findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .stream()
                .map(clientMapper::toDto)
                .toList();
    }
}
