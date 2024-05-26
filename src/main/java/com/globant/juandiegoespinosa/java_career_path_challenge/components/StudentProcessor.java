package com.globant.juandiegoespinosa.java_career_path_challenge.components;

import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.StudentDTO;
import com.globant.juandiegoespinosa.java_career_path_challenge.models.entities.Student;
import com.globant.juandiegoespinosa.java_career_path_challenge.services.IStudentService;
import com.globant.juandiegoespinosa.java_career_path_challenge.use_cases.CreateStudentUseCase;
import com.globant.juandiegoespinosa.java_career_path_challenge.use_cases.DeleteStudentUseCase;
import com.globant.juandiegoespinosa.java_career_path_challenge.use_cases.GetActiveStudentUseCase;
import com.globant.juandiegoespinosa.java_career_path_challenge.use_cases.GetStudentUseCase;
import com.globant.juandiegoespinosa.java_career_path_challenge.use_cases.UpdateStudentUseCase;
import com.globant.juandiegoespinosa.java_career_path_challenge.utils.StudentAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@Component
public class StudentProcessor {

    private final IStudentService service;

    @Autowired
    public StudentProcessor(IStudentService service) {
        this.service = service;
    }

    /**
     * Procesa la creación de un estudiante
     *
     * @param requestBody Objeto de solicitud
     * @return Single con DTO de la entidad creada
     */
    public StudentDTO processCreate(final StudentDTO requestBody) {
        Student created = new CreateStudentUseCase(service, requestBody).execute();

        return StudentAdapter.convert(created);

    }

    /**
     * Procesa la actualización del estudiante indicado
     *
     * @param id          ID del estudiante a actualizar
     * @param requestBody Objeto de solicitud
     * @return Completable confirmando la actualización de la entidad
     */
    public StudentDTO processUpdate(final int id, final StudentDTO requestBody) {
        Student updated = new UpdateStudentUseCase(service, id, requestBody).execute();

        return StudentAdapter.convert(updated);
    }

    /**
     * Obtiene un Single del estudiante consultado
     *
     * @param id ID del estudiante a consultar
     * @return Single con DTO de entidad consultada
     */
    public Optional<StudentDTO> processFindById(final int id) {
        Optional<Student> opt = new GetStudentUseCase(service, id).execute();
        if (opt.isEmpty()) return Optional.empty();

        return Optional.of(StudentAdapter.convert(opt.get()));

    }

    /**
     * Procesa la consulta de todos los estudiantes en estado activo
     *
     * @return Observable de los estudiantes consultados
     */
    public List<StudentDTO> processFindActives() {
        return new GetActiveStudentUseCase(service).execute()
                .stream()
                .map(StudentAdapter::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Procesa el borrado del estudiante indicado
     *
     * @param id ID del estudiante a eliminar
     * @return Completable confirmando el borrado de la entidad
     */
    public Boolean processDelete(final int id) {
        new DeleteStudentUseCase(service, id).execute();

        return true;
    }
}