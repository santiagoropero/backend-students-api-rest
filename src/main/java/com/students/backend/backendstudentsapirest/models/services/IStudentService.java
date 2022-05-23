package com.students.backend.backendstudentsapirest.models.services;

import com.students.backend.backendstudentsapirest.models.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {

    public List<Student> findAll();

    public Page<Student> findAll(Pageable pageable);

    public Student findById(Long id);

    public Student save(Student student);

    public void delete(Long id);
}
