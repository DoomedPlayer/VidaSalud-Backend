package com.BinarySeint.vsBFF.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BinarySeint.vsBFF.service.AuditClient;
import com.BinarySeint.vsBFF.service.CatalogClient;
import com.BinarySeint.vsBFF.service.CitasClient;
import com.BinarySeint.vsBFF.service.ReportClient;

@RestController
@RequestMapping("/api/bff")
public class BffController {

    private final CatalogClient catalogClient;
    private final CitasClient CitasClient;
    private final ReportClient reportClient;
    private final AuditClient auditClient;

    public BffController(CatalogClient catalogClient, 
                         CitasClient citasClient,
                         ReportClient reportClient,
                         AuditClient auditClient) {
        this.catalogClient = catalogClient;
        this.CitasClient = citasClient;
        this.reportClient = reportClient;
        this.auditClient = auditClient;
    }

    @GetMapping("/catalog/services")
    public ResponseEntity<Object> proxyGetCatalogServices() {
        return catalogClient.getServices();
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> proxyCreateAppointment(@RequestBody Object atencion) {
        return CitasClient.createAppointment(atencion);
    }

    @GetMapping("/report/kpis")
    public ResponseEntity<Object> proxyGetKpisToday() {
        return reportClient.getKpisToday();
    }

    @GetMapping("/audit")
    public ResponseEntity<Object> proxyGetAllAudits() {
        return auditClient.getAllAudits();
    }
}
