package com.caching.radis.controller;

import com.caching.radis.entity.Student;
import com.caching.radis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    @Cacheable(value = "students", key = "#id")
    public Student getStudent(@PathVariable  Integer id){
        log.info("getStudent() of student controller is called");
        return studentService.getStudent(id);
    }

    @GetMapping("/all")
    @Cacheable("students")
    public List<Student> getStudents(){
        log.info("called in db");
        return studentService.getStudents();
    }

    @PutMapping("/{id}")
    @CachePut(value = "students",key = "#id")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        log.info("updateStudent() of student controller is called");
        return studentService.updateStudent(student,id);
    }
    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}
