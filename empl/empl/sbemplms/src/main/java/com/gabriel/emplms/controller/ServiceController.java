package com.gabriel.emplms.controller;

import com.gabriel.emplms.model.Service;
import com.gabriel.emplms.service.ServiceDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private ServiceDataService serviceDataService;

    @GetMapping("/api/service")
    public ResponseEntity<?> listService() {
        try {
            Service[] services = serviceDataService.getAllService();
            return ResponseEntity.ok(services);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/api/service")
    public ResponseEntity<?> add(@RequestBody Service service) {
        try {
            Service newService = serviceDataService.createService(service);
            return ResponseEntity.ok(newService);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/api/service/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            Service service = serviceDataService.getService(id);
            return ResponseEntity.ok(service);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/api/service/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            serviceDataService.deleteService(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}