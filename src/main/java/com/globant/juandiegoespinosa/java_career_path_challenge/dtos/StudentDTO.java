package com.globant.juandiegoespinosa.java_career_path_challenge.dtos;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public record StudentDTO(int id,
                         String names,
                         String surnames,
                         String email,
                         String phoneNumber,
                         boolean active,
                         long createdAt,
                         long latestUpdate) {
}