package com.example.image_backend.rabbit_listeners;

import com.example.image_backend.config.RabbitMq;
import com.example.image_backend.dto.SaveImageMessage;
import com.example.image_backend.exception.SaveImageException;
import com.example.image_backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ImageListener {

    private final ImageService imageService;

    @RabbitListener(queues = RabbitMq.IMAGES_QUEUE_NAME)
    public void handleSaveImageMessage(SaveImageMessage saveImageMessage) throws SaveImageException {
        log.info("Save image with path = " + saveImageMessage.getImagePath());
        imageService.saveImageToStorage(saveImageMessage);
    }

}
