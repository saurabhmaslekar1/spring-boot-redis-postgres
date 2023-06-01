package com.caching.radis.service.Impl;

import com.caching.radis.entity.Student;
import com.caching.radis.repository.StudentRepository;
import com.caching.radis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student getStudent(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> addStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>("Student added successfully with ID"+student.getId(), HttpStatus.ACCEPTED);
    }


}
