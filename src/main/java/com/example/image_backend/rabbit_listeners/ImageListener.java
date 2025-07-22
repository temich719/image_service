package com.example.image_backend.rabbit_listeners;

import com.example.image_backend.config.RabbitMq;
import com.example.image_backend.dto.SaveImageMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ImageListener {

    @RabbitListener(queues = RabbitMq.IMAGES_QUEUE_NAME)
    public void handleSaveImageMessage(SaveImageMessage saveImageMessage) {

    }

}
