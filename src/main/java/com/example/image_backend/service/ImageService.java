package com.example.image_backend.service;

import com.example.image_backend.dto.SaveImageMessage;
import org.springframework.core.io.Resource;

public interface ImageService {

    void saveImageToStorage(SaveImageMessage imageMessage);

    Resource getUserAvatarByPath(String path);

    //get cars

}
