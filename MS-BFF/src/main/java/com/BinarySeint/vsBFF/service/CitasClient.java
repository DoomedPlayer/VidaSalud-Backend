package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(name = "citas-client", url = "http://appointments-svc:8080")
public interface CitasClient {
    @PostMapping("/api/appointments")
    ResponseEntity<Object> createAppointment(@RequestBody Object atencion);
    
    @PutMapping("/api/appointments/{id}/status")
    ResponseEntity<Object> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusMap);
}