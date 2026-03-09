package com.gabriel.emplms.serviceimpl;

import com.gabriel.emplms.entity.NotificationData;
import com.gabriel.emplms.model.Notification;
import com.gabriel.emplms.repository.NotificationDataRepository;
import com.gabriel.emplms.service.NotificationDataService;
import com.gabriel.emplms.transform.TransformNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationServiceImpl implements NotificationDataService {
    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    NotificationDataRepository notificationDataRepository;

    @Autowired
    TransformNotificationService transformNotificationService;

    @Override
    public Notification[] getAllNotification() {
        List<NotificationData> notificationsData = new ArrayList<>();
        List<Notification> notifications = new ArrayList<>();

        notificationDataRepository.findAll().forEach(notificationsData::add);
        Iterator<NotificationData> it = notificationsData.iterator();

        while(it.hasNext()) {
            NotificationData data = it.next();
            Notification model = transformNotificationService.transform(data);
            notifications.add(model);
        }

        Notification[] array = new Notification[notifications.size()];
        for (int i=0; i<notifications.size(); i++){
            array[i] = notifications.get(i);
        }
        return array;
    }

    @Override
    public Notification createNotification(Notification notification) {
        logger.info(" add:Input " + notification.toString());
        NotificationData data = transformNotificationService.transform(notification);
        
        data = notificationDataRepository.save(data);
        logger.info(" Success:Saved notification ID " + data.getNotificationId());

        return transformNotificationService.transform(data);
    }

    @Override
    public Notification getNotification(Integer id) {
        logger.info(" Input id >> " + Integer.toString(id));
        Optional<NotificationData> optional = notificationDataRepository.findById(id);

        if(optional.isPresent()) {
            return transformNotificationService.transform(optional.get());
        }

        logger.info(" Failed >> unable to locate notification id: " + Integer.toString(id));
        return null;
    }

    @Override
    public void deleteNotification(Integer id) {
        logger.info(" Input >> " + Integer.toString(id));
        Optional<NotificationData> optional = notificationDataRepository.findById(id);

        if(optional.isPresent()) {
            notificationDataRepository.delete(optional.get());
            logger.info(" Success >> Deleted notification " + id);
        } else {
            logger.info(" Failed >> unable to locate notification id: " + Integer.toString(id));
        }
    }
}