package com.sahabt.studentmicroservice.service;

import com.sahabt.studentmicroservice.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentEntityService {

    List<StudentEntity> getAllStudents();

    Optional<StudentEntity> addStudent(StudentEntity studentEntity);

    Optional<StudentEntity> updateStudent(StudentEntity studentEntity);

    boolean removeStudent(StudentEntity studentEntity);
}
