package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;


import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.StudentDTO;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;
import com.globant.juandiegoespinosa.java_career_path_challenge.utils.StudentAdapter;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public class CreateStudentUseCase extends AbstractUseCase<Student> {

    private final IStudentService service;
    private final StudentDTO requestBody;

    public CreateStudentUseCase(IStudentService service,
                                StudentDTO requestBody) {
        this.service = service;
        this.requestBody = requestBody;
    }

    @Override
    protected Student process() {
        Student student = StudentAdapter.convert(requestBody);

        return service.create(student);
    }
}