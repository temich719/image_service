package com.example.image_backend.service.impl;

import com.example.image_backend.dto.SaveImageMessage;
import com.example.image_backend.exception.SaveImageException;
import com.example.image_backend.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private static final String WRITE_BYTES_ERROR = "Error during write image bytes to file.";

    //todo cross platform path(or before docker change this)
    @Value("${location.storage.win.images}")
    private String storagePath;

    @Override
    public void saveImageToStorage(SaveImageMessage imageMessage) throws SaveImageException {
        Path pathForSave = Paths.get(storagePath).resolve(imageMessage.getImagePath());
        try {
            Files.write(pathForSave, imageMessage.getImageBytes());
        } catch (IOException e) {
            log.error(WRITE_BYTES_ERROR);
            throw new SaveImageException(WRITE_BYTES_ERROR);
        }
    }
}
