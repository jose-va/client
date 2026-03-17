package com.example.client.model;

import com.example.client.service.MainTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Client extends MainTable {

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

    @DynamoDbSortKey
    public String getCifNifNie() {
        return cifNifNie;
    }
}
