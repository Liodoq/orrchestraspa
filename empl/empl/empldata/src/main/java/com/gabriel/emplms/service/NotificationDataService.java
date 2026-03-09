package com.gabriel.emplms.service;

import com.gabriel.emplms.entity.NotificationData;
import java.util.List;

public interface NotificationDataService {
    List<NotificationData> getAllNotifications() throws Exception;
    NotificationData getNotification(Integer notificationId) throws Exception;
    NotificationData createNotification(NotificationData notification) throws Exception;
    NotificationData updateNotification(NotificationData notification) throws Exception;
    void deleteNotification(Integer notificationId) throws Exception;
}