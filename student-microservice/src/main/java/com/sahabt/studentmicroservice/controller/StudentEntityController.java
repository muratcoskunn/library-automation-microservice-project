package com.sahabt.studentmicroservice.controller;

import com.sahabt.studentmicroservice.entity.StudentEntity;
import com.sahabt.studentmicroservice.service.StudentEntityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@RequestScope
@CrossOrigin
public class StudentEntityController {
    StudentEntityService studentEntityService;

    public StudentEntityController(StudentEntityService studentEntityService) {
        this.studentEntityService = studentEntityService;
    }
    @GetMapping
    public List<StudentEntity> getAllStudents(){
        return studentEntityService.getAllStudents();
    }
    @PostMapping
    public Optional<StudentEntity> addStudent(@RequestBody StudentEntity studentEntity){
        return studentEntityService.addStudent(studentEntity);
    }
    @PutMapping
    public Optional<StudentEntity> updateStudent(@RequestBody StudentEntity studentEntity){
        return studentEntityService.updateStudent(studentEntity);
    }
    @DeleteMapping
    public boolean removeStudent(@RequestBody StudentEntity studentEntity){
        return studentEntityService.removeStudent(studentEntity);
    }
}
