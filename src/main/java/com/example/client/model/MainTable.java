package com.example.client.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamoDBTable(tableName = "MainTable")
public class MainTable {

    @DynamoDBHashKey(attributeName = "PK")
    private String pk;

    @DynamoDBRangeKey(attributeName = "SK")
    private String sk;

    @DynamoDBAttribute(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "status")
    private String status;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "GI2_PK", attributeName = "gIndex2Pk")
    private String gIndex2Pk;

    @DynamoDBAttribute(attributeName = "createdDate")
    private Date createdDate;
}
