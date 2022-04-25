package com.sahabt.studentmicroservice.adapter;

import com.sahabt.studentmicroservice.entity.StudentEntity;
import com.sahabt.studentmicroservice.repository.StudentEntityRepository;
import domain.book.Book;
import domain.user.Identity;
import domain.user.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import repository.UserCrudRepository;
import java.util.List;
import java.util.Optional;

@Component
public class StudentAppSpringJpaAdapter implements UserCrudRepository<Student> {
    StudentEntityRepository studentEntityRepository;
    ModelMapper modelMapper;

    public StudentAppSpringJpaAdapter(StudentEntityRepository studentEntityRepository, ModelMapper modelMapper) {
        this.studentEntityRepository = studentEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Student> getAllUsers() {
    var studentEntities = studentEntityRepository.findAll();
    var students = studentEntities.stream().map(studentEntity -> modelMapper.map(studentEntity,Student.class)).toList();
    return students;
}

    @Override
    public boolean existsByIdentity(Identity identity) {
        return studentEntityRepository.existsById(identity.getValue());
    }

    @Override
    public Optional<Student> addUser(Student student) {
        if(existsByIdentity(student.getIdentity())){
            return Optional.empty();
        }
        var studentEntity = modelMapper.map(student, StudentEntity.class);
        studentEntityRepository.save(studentEntity);
        return Optional.of(student);
    }

    @Override
    public boolean removeUser(Student student) {
        if(existsByIdentity(student.getIdentity())){
            var studentEntity = modelMapper.map(student, StudentEntity.class);
            studentEntityRepository.delete(studentEntity);
            return true;
        }
        return false;
    }

    @Override
    public Student updateUser(Student student) {
        var studentEntity = modelMapper.map(student, StudentEntity.class);
        var updatedStudentEntity = studentEntityRepository.save(studentEntity);
        var updatedStudent = modelMapper.map(updatedStudentEntity,Student.class);
        return updatedStudent;
    }

    @Override
    public Optional<Student> findById(Identity identity) {
        return Optional.empty();
    }

}
