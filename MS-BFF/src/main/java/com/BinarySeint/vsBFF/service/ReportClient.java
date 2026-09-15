package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "report-client", url = "http://report-svc:8080")
public interface ReportClient {
    @GetMapping("/api/report/kpis")
    ResponseEntity<Object> getKpisToday();
}