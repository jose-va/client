package com.example.client.service;

import com.example.client.dto.ClientDTO;
import com.example.client.dto.MerchantDTO;
import com.example.client.mappers.ClientMapper;
import com.example.client.merchant.MerchantClient;
import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    private final MerchantClient merchantClient;

    public void saveClient(ClientDTO dto) {
        Client client= clientMapper.toEntity(dto);

        client.setId(UUID.randomUUID().toString());
        client.setPk("CLIENT#" + client.getId());
        client.setSk("NIF#" + client.getCifNifNie());
        client.setGIndex1Pk("STATUS#ACTIVE");

        clientRepository.save(client);
    }

    public void updateClient(ClientDTO dto) {

        Client updatedClient = clientMapper.toEntity(dto);

        updatedClient.setPk("CLIENT#" + updatedClient.getId());
        updatedClient.setSk("NIF#" + updatedClient.getCifNifNie());
        updatedClient.setGIndex1Pk("STATUS#ACTIVE");

        clientRepository.save(updatedClient);
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ClientDTO> findByEmail(String email) {
        return clientRepository.findAll()
                .stream()
                .filter(c -> c.getEmail().toLowerCase().contains(email.toLowerCase()))
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ClientDTO> findByName(String name) {
        return clientRepository.findAll()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ClientDTO> findById(String id) {
        return clientRepository.findAll()
                .stream()
                .filter(c -> c.getId().toLowerCase().contains(id.toLowerCase()))
                .map(clientMapper::toDto)
                .toList();
    }

    public List<ClientDTO> findByMerchant(String merchantId) {
        MerchantDTO merchantDTO= merchantClient.findMerchant(merchantId);
        return this.findById(merchantDTO.getClientId());
    }

    public void deleteClient(String id, String nif){
        String pk = "CLIENT#" + id;
        String sk = "NIF#" + nif;

        Client client = clientRepository.findById(pk, sk);
        clientRepository.delete(client);
    }
}
