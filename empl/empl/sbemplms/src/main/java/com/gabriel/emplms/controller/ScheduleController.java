package com.gabriel.emplms.controller;

import com.gabriel.emplms.model.Schedule;
import com.gabriel.emplms.service.ScheduleDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {

    Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private ScheduleDataService scheduleDataService;

    @GetMapping("/api/schedule")
    public ResponseEntity<?> listSchedule() {
        try {
            Schedule[] schedules = scheduleDataService.getAllSchedule();
            return ResponseEntity.ok(schedules);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/api/schedule")
    public ResponseEntity<?> add(@RequestBody Schedule schedule) {
        try {
            Schedule newSchedule = scheduleDataService.createSchedule(schedule);
            return ResponseEntity.ok(newSchedule);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/api/schedule/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            Schedule schedule = scheduleDataService.getSchedule(id);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/api/schedule/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            scheduleDataService.deleteSchedule(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}