package com.example.client.dto;

import lombok.*;

@Data
public class MerchantDTO {
    private String id;
    private String name;
    private String address;
    private MerchantType merchantType;
    private String clientId;
}
