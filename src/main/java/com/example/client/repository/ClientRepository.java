package com.example.client.repository;

import com.example.client.service.MainTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Repository
@DynamoDbBean
public interface ClientRepository{

}
