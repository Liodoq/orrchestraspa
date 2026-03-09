package com.gabriel.emplms.service;

import com.gabriel.emplms.entity.UserData;
import java.util.List;

public interface UserDataService {
    List<UserData> getAllUser() throws Exception;
    UserData getUser(Integer userId) throws Exception;
    UserData createUser(UserData user) throws Exception;
    UserData updateUser(UserData user) throws Exception;
    void deleteUser(Integer userId) throws Exception;
}