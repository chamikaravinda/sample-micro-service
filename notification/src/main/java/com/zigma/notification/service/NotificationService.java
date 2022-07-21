package com.zigma.notification.service;

import com.zigma.clients.notification.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
