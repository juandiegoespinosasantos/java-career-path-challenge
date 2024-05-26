package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;


import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;

import java.util.List;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public class GetActiveStudentUseCase extends AbstractUseCase<List<Student>> {

    private final IStudentService service;

    public GetActiveStudentUseCase(IStudentService service) {
        this.service = service;
    }

    @Override
    protected List<Student> process() {
        return service.findActives();
    }
}