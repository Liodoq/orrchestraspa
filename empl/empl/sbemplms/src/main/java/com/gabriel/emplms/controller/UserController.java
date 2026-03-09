package com.gabriel.emplms.controller;

import com.gabriel.emplms.model.User;
import com.gabriel.emplms.service.UserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/api/user")
    public ResponseEntity<?> listUser() {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            User[] users = userDataService.getAllUser();
            response = ResponseEntity.ok().headers(headers).body(users);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/api/user")
    public ResponseEntity<?> add(@RequestBody User user) {
        logger.info("Input >> " + user.toString());
        ResponseEntity<?> response;
        try {
            User newUser = userDataService.createUser(user);
            logger.info("Created user >> " + newUser.toString());
            response = ResponseEntity.ok(newUser);
        } catch (Exception ex) {
            logger.error("Failed to create user: {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PostMapping("/api/user")
    public ResponseEntity<?> update(@RequestBody User user) {
        logger.info("Update Input >> " + user.toString());
        ResponseEntity<?> response;
        try {
            User updatedUser = userDataService.updateUser(user);
            response = ResponseEntity.ok(updatedUser);
        } catch (Exception ex) {
            logger.error("Failed to update user: {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> get(@PathVariable final Integer id) {
        logger.info("Input user id >> " + Integer.toString(id));
        ResponseEntity<?> response;
        try {
            User user = userDataService.getUser(id);
            response = ResponseEntity.ok(user);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> delete(@PathVariable final Integer id) {
        logger.info("Input >> " + Integer.toString(id));
        ResponseEntity<?> response;
        try {
            userDataService.deleteUser(id);
            response = ResponseEntity.ok(null);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}