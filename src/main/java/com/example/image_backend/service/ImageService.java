package com.example.image_backend.service;

import com.example.image_backend.dto.SaveImageMessage;
import com.example.image_backend.exception.SaveImageException;

public interface ImageService {

    void saveImageToStorage(SaveImageMessage imageMessage) throws SaveImageException;

}
