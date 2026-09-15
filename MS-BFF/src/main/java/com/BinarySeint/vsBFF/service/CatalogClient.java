package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "catalog-client", url = "http://catalog-svc:8080")
public interface CatalogClient {
    @GetMapping("/api/catalog/services")
    ResponseEntity<Object> getServices();
}