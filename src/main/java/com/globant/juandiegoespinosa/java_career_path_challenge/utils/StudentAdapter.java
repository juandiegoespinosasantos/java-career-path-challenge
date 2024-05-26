package com.globant.juandiegoespinosa.java_career_path_challenge.utils;

import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.StudentDTO;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StudentAdapter {

    public static StudentDTO convert(final Student source) {
        java.sql.Timestamp createdAt = source.getCreatedAt();
        long ca = (createdAt == null) ? 0L : createdAt.getTime();

        java.sql.Timestamp latestUpdate = source.getLatestUpdate();
        long lu = (latestUpdate == null) ? 0L : latestUpdate.getTime();

        return new StudentDTO(source.getId(),
                source.getNames(),
                source.getSurnames(),
                source.getEmail(),
                source.getPhoneNumber(),
                source.isActive(),
                ca,
                lu);
    }

    public static Student convert(final StudentDTO source) {
        return Student.builder()
                .id(source.id())
                .names(source.names())
                .surnames(source.surnames())
                .email(source.email())
                .phoneNumber(source.phoneNumber())
                .active(source.active())
                .createdAt(new java.sql.Timestamp(source.createdAt()))
                .latestUpdate(new java.sql.Timestamp(source.latestUpdate()))
                .build();
    }
}
