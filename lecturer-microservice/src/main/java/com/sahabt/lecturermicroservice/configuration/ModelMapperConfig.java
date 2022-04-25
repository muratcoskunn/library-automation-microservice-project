package com.sahabt.lecturermicroservice.configuration;

import com.sahabt.lecturermicroservice.entity.LecturerEntity;
import domain.user.Lecturer;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static final Converter<LecturerEntity, Lecturer> LECTURER_ENTITY_TO_LECTURER_CONVERTER = (context) ->{return
            new Lecturer.Builder().identity(context.getSource().getLecturerId())
                    .fullname(context.getSource().getName(),context.getSource().getSurname())
                    .department(context.getSource().getDepartment()).build();};
    private static final Converter<Lecturer,LecturerEntity> LECTURER_TO_LECTURER_ENTITY_CONVERTER = (context) ->{return
            new LecturerEntity(context.getSource().getIdentity().getValue(),context.getSource().getFullName().getName()
                    ,context.getSource().getFullName().getSurname(),context.getSource().getDepartment().getValue());};

    @Bean
    public ModelMapper createModelMapper(){
        var modelMapper= new ModelMapper();
        modelMapper.addConverter(LECTURER_ENTITY_TO_LECTURER_CONVERTER,LecturerEntity.class,Lecturer.class);
        modelMapper.addConverter(LECTURER_TO_LECTURER_ENTITY_CONVERTER,Lecturer.class,LecturerEntity.class);
        return modelMapper;
    }
}
