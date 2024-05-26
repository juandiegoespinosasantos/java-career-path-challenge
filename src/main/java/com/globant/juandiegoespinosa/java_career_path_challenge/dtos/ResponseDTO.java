package com.globant.juandiegoespinosa.java_career_path_challenge.dtos;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public record ResponseDTO(String message, Object payload) {

    public ResponseDTO(String message) {
        this(message, null);
    }
}