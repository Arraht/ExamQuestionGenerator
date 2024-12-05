package com.generator.exam.generator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}