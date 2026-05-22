package com.example.client.mappers;

import com.example.client.dto.ClientDTO;
import com.example.client.model.Client;
import com.example.client.model.MainTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDto(Client client);
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "phone", target = "phone")
    Client toEntity(ClientDTO clientDto);
}
