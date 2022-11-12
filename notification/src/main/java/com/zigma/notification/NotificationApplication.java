package com.zigma.notification;

import com.zigma.advanceMsgQueue.producer.RabbitMqMessageProducer;
import com.zigma.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "com.zigma.notification",
                "com.zigma.advanceMsgQueue",
        }
)
public class NotificationApplication {
    public static void main(String[] args){
        SpringApplication.run(NotificationApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMqMessageProducer producer,
            NotificationConfig config
            ){
        return args -> {
            producer.publish(
                    "foo",
                    config.getInternalExchange(),
                    config.getInternalNotificationRoutingKey()
            );
        };
    }
}
