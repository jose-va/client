package com.example.client.mappers;

import com.example.client.dto.ClientDTO;
import com.example.client.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDto(Client client);
    Client toEntity(ClientDTO clientDto);
}
