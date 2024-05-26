package com.globant.juandiegoespinosa.java_career_path_challenge.services;

import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public interface IStudentService {

    Student create(Student entity);

    Student edit(Student entity);

    Optional<Student> findById(int id);

    List<Student> findActives();

    void delete(int id);
}