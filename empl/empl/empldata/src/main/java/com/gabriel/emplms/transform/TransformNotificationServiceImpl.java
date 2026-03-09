package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.NotificationData;
import com.gabriel.emplms.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class TransformNotificationServiceImpl implements TransformNotificationService {

    @Override
    public NotificationData transform(Notification notification) {
        NotificationData notificationData = new NotificationData();
        // Map the fields from model to entity
        notificationData.setNotificationId(notification.getNotificationId());
        notificationData.setMessage(notification.getMessage());
        
        // Standard notification default
        notificationData.setRead(false);
        return notificationData;
    }
    @Override
    public Notification transform(NotificationData notificationData) {
        Notification notification = new Notification();
        notification.setNotificationId(notificationData.getNotificationId());
        notification.setMessage(notificationData.getMessage());
    
        // Standard notification default
        notification.setRead(false);
        return notification;
    }
}