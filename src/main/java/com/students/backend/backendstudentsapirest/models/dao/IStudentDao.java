package com.students.backend.backendstudentsapirest.models.dao;

import com.students.backend.backendstudentsapirest.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentDao extends JpaRepository<Student, Long> {
}
