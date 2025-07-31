package com.example.image_backend.controller;

import com.example.image_backend.exception.SaveImageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class ExceptionController {

    private static final String CANT_SAVE_IMAGE_TO_STORAGE = "Can't save image to storage!";

    @ExceptionHandler(SaveImageException.class)
    public ResponseEntity<String> handleSaveImageException(SaveImageException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(CANT_SAVE_IMAGE_TO_STORAGE);
    }

}
