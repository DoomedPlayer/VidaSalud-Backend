package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "audit-client", url = "http://audit-svc:8080")
public interface AuditClient {
    @GetMapping("/api/audit")
    ResponseEntity<Object> getAllAudits();
}