package com.example.client.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.client.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ClientRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public void save(Client client) {
        dynamoDBMapper.save(client);
    }

    public Client findById(String pk, String sk) {
        return dynamoDBMapper.load(Client.class, pk, sk);
    }

    public List<Client> findAll() {
        return dynamoDBMapper.scan(Client.class, new DynamoDBScanExpression());
    }
}
