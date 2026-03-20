package com.example.client.merchant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "merchant", url="http://localhost:8081/api/merchant")
public interface MerchantClient {

    @GetMapping("/find/{id}")
    Optional<MerchantDTO> findById(@PathVariable String id, @RequestParam String address);
}
