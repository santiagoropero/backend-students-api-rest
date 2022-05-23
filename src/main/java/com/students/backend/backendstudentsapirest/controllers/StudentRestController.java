package com.students.backend.backendstudentsapirest.controllers;

import com.students.backend.backendstudentsapirest.models.entity.Student;
import com.students.backend.backendstudentsapirest.models.services.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private IStudentService studentService;

    private final Logger log = LoggerFactory.getLogger(StudentRestController.class);

    @GetMapping("/students")
    public List<Student> index() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@Valid @RequestBody Student student, BindingResult result) {
        Student newCliente = null;
        Map<String, Object> response = new HashMap<>();
        System.out.println(result);
        if (result.hasErrors()) {
            log.error("Error hasErros");
            List<String> errores = result.getFieldErrors()
                    .stream()
                    .map(fieldError -> "El campo" + "'" + fieldError.getField() + "'" + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newCliente = studentService.save(student);
        } catch (DataAccessException dataAccessException) {
            log.error("Errores " + dataAccessException.getMessage());
            response.put("mensaje", "Error en la base de datos al crear cliente");
            response.put("error", dataAccessException.getMessage().concat(": ").concat(dataAccessException.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha creado con exito");
        response.put("cliente", newCliente);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
