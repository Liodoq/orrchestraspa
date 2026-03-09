package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.UserData;
import com.gabriel.emplms.model.User;

public interface TransformUserService {
    // Converts the simple model to the database entity
    UserData transform(User user);
    User transform(UserData userData);
}