package com.globant.juandiegoespinosa.java_career_path_challenge.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@Data
public class StudentException extends Exception {

    private HttpStatus httpStatus;
    private String message;

    public StudentException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}