package com.zigma.notification.controler;

import com.zigma.clients.notification.NotificationRequest;
import com.zigma.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationControler {

    public final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Inside the sendNotification method");
        log.info("New Notification... {}",notificationRequest);
        notificationService.send(notificationRequest);
    }
}
