package com.gabriel.emplms.service;

import com.gabriel.emplms.model.User;

public interface UserDataService {
    User[] getAllUser() throws Exception;
    User getUser(Integer userId) throws Exception;
    User createUser(User user) throws Exception;
    User updateUser(User user) throws Exception;
    void deleteUser(Integer userId) throws Exception;
}