package me.dio.santanderbootcamp2023.controller.exception;

import jakarta.persistence.EntityExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> handleBusinessException(EntityExistsException entityExistsException) {
        return new ResponseEntity<>(entityExistsException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("Resource ID not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs!";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
