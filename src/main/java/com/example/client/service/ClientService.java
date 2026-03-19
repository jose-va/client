package com.example.client.service;

import com.example.client.dto.ClientDTO;
import com.example.client.mappers.ClientMapper;
import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void saveClient(ClientDTO dto) {
        Client client= clientMapper.toEntity(dto);

        client.setPk("CLIENT#" + client.getId());
        client.setSk("NIF#" + client.getCifNifNie());
        client.setGIndex2Pk("PHONE#" + client.getPhone());

        clientRepository.save(client);
    }

    public ClientDTO findById(String id) {
        Client client = clientRepository.findById(id);
        if (client == null) throw new RuntimeException("Cliente no encontrado");

        return clientMapper.toDto(client);
    }

    public void deleteClient(String id) {
        Client client = clientRepository.findById(id);
        if (client == null) throw new RuntimeException("Cliente no encontrado");

        clientRepository.delete(client);
    }
}
