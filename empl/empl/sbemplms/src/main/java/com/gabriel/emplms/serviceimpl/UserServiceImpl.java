package com.gabriel.emplms.serviceimpl;

import com.gabriel.emplms.entity.UserData;
import com.gabriel.emplms.model.User;
import com.gabriel.emplms.repository.UserDataRepository;
import com.gabriel.emplms.service.UserDataService;
import com.gabriel.emplms.transform.TransformUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserDataService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    TransformUserService transformUserService;

    @Override
    public User[] getAllUser() {
        List<UserData> usersData = new ArrayList<>();
        List<User> users = new ArrayList<>();

        userDataRepository.findAll().forEach(usersData::add);
        Iterator<UserData> it = usersData.iterator();

        while(it.hasNext()) {
            UserData userData = it.next();
            User user = transformUserService.transform(userData);
            users.add(user);
        }

        User[] array = new User[users.size()];
        for (int i=0; i<users.size(); i++){
            array[i] = users.get(i);
        }
        return array;
    }

    @Override
    public User createUser(User user) {
        logger.info(" add:Input " + user.toString());
        UserData userData = transformUserService.transform(user);
        
        userData = userDataRepository.save(userData);
        logger.info(" Success:Saved user ID " + userData.getUserId());

        return transformUserService.transform(userData);
    }

    @Override
    public User updateUser(User user) {
        UserData userData = transformUserService.transform(user);
        userData = userDataRepository.save(userData);
        return transformUserService.transform(userData);
    }

    @Override
    public User getUser(Integer id) {
        logger.info(" Input id >> " + Integer.toString(id));
        Optional<UserData> optional = userDataRepository.findById(id);

        if(optional.isPresent()) {
            return transformUserService.transform(optional.get());
        }

        logger.info(" Failed >> unable to locate user id: " + Integer.toString(id));
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        logger.info(" Input >> " + Integer.toString(id));
        Optional<UserData> optional = userDataRepository.findById(id);

        if(optional.isPresent()) {
            userDataRepository.delete(optional.get());
            logger.info(" Success >> Deleted user " + id);
        } else {
            logger.info(" Failed >> unable to locate user id: " + Integer.toString(id));
        }
    }
}