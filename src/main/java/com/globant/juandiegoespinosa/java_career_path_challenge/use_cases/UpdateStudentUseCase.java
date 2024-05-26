package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;

import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.StudentDTO;
import com.globant.juandiegoespinosa.java_career_path_challenge.exceptions.StudentException;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;
import com.globant.juandiegoespinosa.java_career_path_challenge.utils.StudentAdapter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public class UpdateStudentUseCase extends AbstractUseCase<Student> {

    private final IStudentService service;
    private final int id;
    private final StudentDTO requestBody;

    private Student pivot;

    public UpdateStudentUseCase(IStudentService service,
                                int id,
                                StudentDTO requestBody) {
        this.service = service;
        this.id = id;
        this.requestBody = requestBody;
    }

    @Override
    protected void validate() throws Exception {
        Optional<Student> opt = service.findById(id);

        if (opt.isEmpty()) {
            throw new StudentException(HttpStatus.NOT_FOUND, "Estudiante [" + id + "] no registrado");
        }

        pivot = opt.get();
    }

    @Override
    protected Student process() {
        Student student = StudentAdapter.convert(requestBody);
        student.setId(pivot.getId());
        student.setCreatedAt(pivot.getCreatedAt());

        return service.edit(student);
    }
}