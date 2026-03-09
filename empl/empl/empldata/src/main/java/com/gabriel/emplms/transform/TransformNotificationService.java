package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.NotificationData;
import com.gabriel.emplms.model.Notification;

public interface TransformNotificationService {
    NotificationData transform(Notification notification);
    Notification transform(NotificationData notificationData);
}