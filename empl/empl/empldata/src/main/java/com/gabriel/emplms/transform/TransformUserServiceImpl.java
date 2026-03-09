package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.UserData;
import com.gabriel.emplms.model.User;
import org.springframework.stereotype.Service;

@Service
public class TransformUserServiceImpl implements TransformUserService {

    @Override
    public UserData transform(User user) {
        UserData userData = new UserData();
        // Map the fields from model to entity
        userData.setUserName(user.getUserName());
        userData.setUserEmail(user.getUserEmail());
        userData.setUserPassword(user.getUserPassword());
        userData.setRole(user.getRole());
        return userData;
    }

    @Override
    public User transform(UserData userData) {
        User user = new User();
        // Map the fields from model to entity
        user.setUserName(userData.getUserName());
        user.setUserEmail(userData.getUserEmail());
        user.setUserPassword(userData.getUserPassword());
        user.setRole(userData.getRole());
        return user;
    }

}