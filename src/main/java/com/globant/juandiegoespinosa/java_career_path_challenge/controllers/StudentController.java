package com.globant.juandiegoespinosa.java_career_path_challenge.controllers;

import com.globant.juandiegoespinosa.java_career_path_challenge.components.StudentProcessor;
import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.ResponseDTO;
import com.globant.juandiegoespinosa.java_career_path_challenge.dtos.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
@RestController
@RequestMapping("/v1/students")
@CrossOrigin
public class StudentController {

    private final StudentProcessor processor;

    @Autowired
    public StudentController(StudentProcessor processor) {
        this.processor = processor;
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> create(@RequestBody StudentDTO requestBody) {
        StudentDTO created = processor.processCreate(requestBody);
        ResponseDTO response = new ResponseDTO("Estudiante creado exitosamente", created);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> update(@PathVariable("id") int id,
                                              @RequestBody StudentDTO requestBody) {
        StudentDTO updated = processor.processUpdate(id, requestBody);
        ResponseDTO response = new ResponseDTO("Estudiante actualizado exitosamente", updated);

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> findOne(@PathVariable("id") int id) {
        Optional<StudentDTO> opt = processor.processFindById(id);
        boolean ok = !opt.isEmpty();
        HttpStatus httpStatus = ok ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        String message = ok ? "Consulta realizada" : "Resultado no encontrado";
        StudentDTO payload = ok ? opt.get() : null;
        ResponseDTO response = new ResponseDTO(message, payload);

        return ResponseEntity.status(httpStatus).body(response);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> findActives() {
        List<StudentDTO> students = processor.processFindActives();
        ResponseDTO response = new ResponseDTO("Registros encontrados: " + students.size(), students);

        return ResponseEntity.ok(response);

    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> delete(@PathVariable("id") int id) {
        processor.processDelete(id);
        ResponseDTO response = new ResponseDTO("Estudiante [" + id + "] eliminado exitosamente");

        return ResponseEntity.ok(response);
    }
}