package com.students.backend.backendstudentsapirest.models.services;

import com.students.backend.backendstudentsapirest.models.dao.IStudentDao;
import com.students.backend.backendstudentsapirest.models.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Student> findAll(Pageable pageable) {
        return studentDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student save(Student cliente) {
        return studentDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentDao.deleteById(id);
    }
}
