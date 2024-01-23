package com.thutohealthcare.medicalsystem.core.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
public class CustomException extends RuntimeException {

    protected String message;
    protected HttpStatus status;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
