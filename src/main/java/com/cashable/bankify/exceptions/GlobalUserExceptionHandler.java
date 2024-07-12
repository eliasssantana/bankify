package com.cashable.bankify.exceptions;

import com.cashable.bankify.dto.impl.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@Slf4j
public class GlobalUserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException ex){
        ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), "NOT_FOUND", 404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
        ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), "CONFLICT", 409, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException ex){
        ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), "BAD_REQUEST", 400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Throwable ex){
        log.error(ex.getMessage());
        System.out.println(ex.getCause());
        System.out.println(ex.getClass());
        ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), "INTERNAL_SERVER_ERROR", 500, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }
}
