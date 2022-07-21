package com.zigma.notification.service.Impl;

import com.zigma.clients.notification.NotificationRequest;
import com.zigma.notification.model.Notification;
import com.zigma.notification.repository.NotificationRepository;
import com.zigma.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
            Notification.builder()
                    .toCustomerId(notificationRequest.toCustomerId())
                    .toCustomerEmail(notificationRequest.toCustomerEmail())
                    .sender("zigma-service")
                    .message(notificationRequest.message())
                    .sentAt(LocalDateTime.now())
                    .build()
        );
    }
}
