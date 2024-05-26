package com.globant.juandiegoespinosa.java_career_path_challenge.models.dao;

import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {

    List<Student> findByActive(boolean active);
}