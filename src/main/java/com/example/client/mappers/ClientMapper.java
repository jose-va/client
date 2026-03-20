package com.example.client.mappers;

import com.example.client.dto.ClientDTO;
import com.example.client.model.Client;
import com.example.client.model.MainTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDto(MainTable mainTable);
    Client toEntity(ClientDTO clientDto);
}
