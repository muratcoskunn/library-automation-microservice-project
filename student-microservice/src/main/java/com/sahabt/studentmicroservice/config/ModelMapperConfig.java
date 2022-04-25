package com.sahabt.studentmicroservice.config;

import domain.user.Student;
import com.sahabt.studentmicroservice.entity.StudentEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static final Converter<StudentEntity, Student> STUDENT_ENTITY_TO_STUDENT_CONVERTER =
            context -> { var studentEntity =context.getSource();
                return new Student.Builder()
                        .identity(studentEntity.getStudentId())
                        .fullName(studentEntity.getName(), studentEntity.getSurname())
                        .department(studentEntity.getDepartment())
                        .build();
            };
    private static final Converter<Student,StudentEntity> STUDENT_TO_STUDENT_ENTITY_CONVERTER = context -> {
        var student = context.getSource();
        return new StudentEntity(student.getIdentity().getValue(),
                student.getFullName().getName(),
                student.getFullName().getSurname(),
                student.getDepartment().getValue());
    };
    @Bean
    public ModelMapper createModelMapper(){
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(STUDENT_ENTITY_TO_STUDENT_CONVERTER,StudentEntity.class,Student.class);
        modelMapper.addConverter(STUDENT_TO_STUDENT_ENTITY_CONVERTER,Student.class,StudentEntity.class);
        return modelMapper;
    }
}
