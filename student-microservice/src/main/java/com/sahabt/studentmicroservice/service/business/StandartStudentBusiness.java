package com.sahabt.studentmicroservice.service.business;

import domain.user.Student;
import application.UserApplication;
import com.sahabt.studentmicroservice.entity.StudentEntity;
import com.sahabt.studentmicroservice.service.StudentEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandartStudentBusiness implements StudentEntityService {
    UserApplication userApplication;
    ModelMapper modelMapper;

    public StandartStudentBusiness(UserApplication userApplication,ModelMapper modelMapper) {
        this.userApplication = userApplication;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        var studentEntities = userApplication.getAllUsers().stream().map(student -> modelMapper.map(student,StudentEntity.class)).toList();
        return studentEntities;
    }

    @Override
    public Optional<StudentEntity> addStudent(StudentEntity studentEntity) {
        var student = modelMapper.map(studentEntity, Student.class);
        var addedStudent = userApplication.addUser(student);
        return Optional.of(modelMapper.map(addedStudent.get(),StudentEntity.class));
    }

    @Override
    public Optional<StudentEntity> updateStudent(StudentEntity studentEntity) {
        var student = modelMapper.map(studentEntity,Student.class);
        var updatedStudent = userApplication.updateUser(student);
        if(updatedStudent.isPresent()){
            var updatedStudentEntity = modelMapper.map(updatedStudent.get(),StudentEntity.class);
            return Optional.of(updatedStudentEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean removeStudent(StudentEntity studentEntity) {
        var student = modelMapper.map(studentEntity,Student.class);
        return userApplication.removeUser(student);
    }
}
