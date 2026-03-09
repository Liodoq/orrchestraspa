package com.gabriel.emplms.service;

import com.gabriel.emplms.model.Notification;

public interface NotificationDataService {
    Notification[] getAllNotification() throws Exception;
    Notification getNotification(Integer id) throws Exception;
    Notification createNotification(Notification notification) throws Exception;
    void deleteNotification(Integer id) throws Exception;
}