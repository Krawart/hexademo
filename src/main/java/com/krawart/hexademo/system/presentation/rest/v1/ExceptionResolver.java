package com.krawart.hexademo.system.presentation.rest.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
class ExceptionResolver {

    @ExceptionHandler
    public ResponseEntity<String> unhandledError(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().body("Oops... \n" + e.getMessage());
    }
}
