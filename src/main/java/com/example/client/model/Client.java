package com.example.client.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "MainTable")
public class Client extends MainTable {

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "surname")
    private String surname;

    @DynamoDBAttribute(attributeName = "cifNifNie")
    private String cifNifNie;

    @DynamoDBAttribute(attributeName = "phone")
    private Long phone;

    @DynamoDBAttribute(attributeName = "email")
    private String email;
}
