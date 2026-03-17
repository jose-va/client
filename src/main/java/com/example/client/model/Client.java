package com.example.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Getter
@Setter
@NoArgsConstructor
@DynamoDbBean
public class Client {

    private String id;

    private String name;

    private String surname;

    private String cifNifNie;

    private Long phone;

    private String email;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
