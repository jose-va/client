package com.example.client.merchant;

import com.example.client.dto.MerchantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "merchant", url="http://localhost:8081/api/merchant")
public interface MerchantClient {
      
    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    MerchantDTO findMerchant(@PathVariable String id);
}
