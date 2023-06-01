package com.caching.radis.service;

import com.caching.radis.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Student getStudent(Integer id);

    List<Student> getStudents();

    ResponseEntity<Object> addStudent(Student student);
}
