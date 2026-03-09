package com.gabriel.emplms.controller;

import com.gabriel.emplms.model.Notification;
import com.gabriel.emplms.service.NotificationDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationDataService notificationDataService;

    @GetMapping("/api/notification")
    public ResponseEntity<?> listNotification() {
        try {
            Notification[] notifications = notificationDataService.getAllNotification();
            return ResponseEntity.ok(notifications);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/api/notification")
    public ResponseEntity<?> add(@RequestBody Notification notification) {
        try {
            Notification newNotification = notificationDataService.createNotification(notification);
            return ResponseEntity.ok(newNotification);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/api/notification/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            Notification notification = notificationDataService.getNotification(id);
            return ResponseEntity.ok(notification);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/api/notification/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            notificationDataService.deleteNotification(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}