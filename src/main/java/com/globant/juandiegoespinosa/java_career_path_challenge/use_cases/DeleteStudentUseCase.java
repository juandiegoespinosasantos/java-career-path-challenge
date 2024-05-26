package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;

import com.globant.juandiegoespinosa.java_career_path_challenge.exceptions.StudentException;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public class DeleteStudentUseCase extends AbstractUseCase<Student> {

    private final IStudentService service;
    private final int id;

    private Student student;

    public DeleteStudentUseCase(IStudentService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    protected void validate() throws Exception {
        Optional<Student> opt = service.findById(id);
        if (opt.isEmpty()) throw new StudentException(HttpStatus.NOT_FOUND, "Estudiante [" + id + "] no registrado");
        student = opt.get();
    }

    @Override
    protected Student process() {
        service.delete(student.getId());

        return student;
    }
}