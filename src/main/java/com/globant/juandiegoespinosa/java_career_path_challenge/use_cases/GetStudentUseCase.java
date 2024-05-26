package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;

import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;

import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public class GetStudentUseCase extends AbstractUseCase<Optional<Student>> {

    private final IStudentService service;
    private final int id;

    public GetStudentUseCase(IStudentService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    protected Optional<Student> process() {
        return service.findById(id);
    }
}