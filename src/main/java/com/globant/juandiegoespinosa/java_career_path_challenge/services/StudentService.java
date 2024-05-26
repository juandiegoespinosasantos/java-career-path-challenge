package com.globant.juandiegoespinosa.java_career_path_challenge.services;

import com.globant.juandiegoespinosa.java_career_path_challenge.models.dao.StudentDAO;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@Service
public class StudentService implements IStudentService {

    private final StudentDAO dao;

    @Autowired
    public StudentService(StudentDAO dao) {
        this.dao = dao;
    }

    @Override
    public Student create(final Student entity) {
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        entity.setCreatedAt(now);
        entity.setLatestUpdate(now);
        entity.setActive(true);

        return dao.save(entity);
    }

    @Override
    public Student edit(final Student entity) {
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        entity.setLatestUpdate(now);

        return dao.save(entity);
    }

    @Override
    public Optional<Student> findById(final int id) {
        return dao.findById(id);
    }

    @Override
    public List<Student> findActives() {
        return dao.findByActive(true);
    }

    @Override
    public void delete(final int id) {
        dao.deleteById(id);
    }
}