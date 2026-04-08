package com.example.client.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
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

    public List<Client> findByEmail(String email) {
        Client filter = new Client();
        filter.setEmail(email);

        DynamoDBQueryExpression<Client> queryExpression = new DynamoDBQueryExpression<Client>()
                .withHashKeyValues(filter)
                .withIndexName("GI2_PK")
                .withConsistentRead(false);

        return dynamoDBMapper.query(Client.class, queryExpression);
    }

    public List<Client> findAll() {
        Client filter = new Client();
        filter.setGIndex1Pk("STATUS#ACTIVE");

        DynamoDBQueryExpression<Client> queryExpression = new DynamoDBQueryExpression<Client>()
                .withHashKeyValues(filter)
                .withIndexName("GI1_PK")
                .withConsistentRead(false);

        return dynamoDBMapper.query(Client.class, queryExpression);
    }

    public void delete(Client client) {
        dynamoDBMapper.delete(client);
    }
}
