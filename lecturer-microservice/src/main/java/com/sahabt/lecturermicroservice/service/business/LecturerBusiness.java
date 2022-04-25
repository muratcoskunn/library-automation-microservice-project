package com.sahabt.lecturermicroservice.service.business;

import application.UserApplication;
import com.sahabt.lecturermicroservice.entity.LecturerEntity;
import com.sahabt.lecturermicroservice.repository.LecturerEntityRepository;
import com.sahabt.lecturermicroservice.service.LecturerService;
import domain.user.Identity;
import domain.user.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerBusiness implements LecturerService {
    LecturerEntityRepository lecturerRepository;
    UserApplication userApplication;
    ModelMapper modelMapper;

    public LecturerBusiness(LecturerEntityRepository lecturerRepository, UserApplication userApplication, ModelMapper modelMapper) {
        this.lecturerRepository = lecturerRepository;
        this.userApplication =userApplication;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<LecturerEntity> getAllLecturers() {
        var lecturerEntities = userApplication.getAllUsers().stream().map(lecturer -> modelMapper.map(lecturer,LecturerEntity.class)).toList();
        return lecturerEntities;
    }

    @Override
    public Optional<LecturerEntity> addLecturer(LecturerEntity lecturerEntity) {
        var lecturer = modelMapper.map(lecturerEntity, Lecturer.class);
        var addedLecturer = userApplication.addUser(lecturer);
        return Optional.of(modelMapper.map(addedLecturer.get(),LecturerEntity.class));
    }

    @Override
    public Optional<LecturerEntity> updateLecturer(LecturerEntity lecturerEntity) {
        var lecturer = modelMapper.map(lecturerEntity,Lecturer.class);
        var updatedLecturer = userApplication.updateUser(lecturer);
        if(updatedLecturer.isPresent()){
            var updatedOfficerEntity = modelMapper.map(updatedLecturer.get(),LecturerEntity.class);
            return Optional.of(updatedOfficerEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean removeLecturer(LecturerEntity lecturerEntity) {
        var lecturer = modelMapper.map(lecturerEntity,Lecturer.class);
        return userApplication.removeUser(lecturer);
    }

    @Override
    public Boolean existsById(String id) {
        return userApplication.existsById(Identity.of(id));
    }
}
