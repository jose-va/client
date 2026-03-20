package com.example.client.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.client.model.Client;
import com.example.client.model.MainTable;
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

    public List<MainTable> findByEmail(String email) {
        MainTable hashKey = MainTable.builder()
                .gIndex2Pk(email)
                .build();

        DynamoDBQueryExpression<MainTable> queryExpression = new DynamoDBQueryExpression<MainTable>()
                .withHashKeyValues(hashKey)
                .withIndexName("GI2_PK")
                .withConsistentRead(false);

        return dynamoDBMapper.query(MainTable.class, queryExpression);
    }

    public List<Client> findAll() {
        return dynamoDBMapper.scan(Client.class, new DynamoDBScanExpression());
    }


}
