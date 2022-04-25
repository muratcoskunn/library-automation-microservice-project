package com.sahabt.lecturermicroservice.adapter;

import com.sahabt.lecturermicroservice.entity.LecturerEntity;
import com.sahabt.lecturermicroservice.repository.LecturerEntityRepository;
import domain.book.Book;
import domain.user.Identity;
import domain.user.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import repository.UserCrudRepository;

import java.util.List;
import java.util.Optional;

@Component
public class LecturerRepoSpringJpaAdapter implements UserCrudRepository<Lecturer> {
    LecturerEntityRepository lecturerEntityRepository;
    ModelMapper modelMapper;


    public LecturerRepoSpringJpaAdapter(LecturerEntityRepository lecturerJpaRepository, ModelMapper modelMapper) {
        this.lecturerEntityRepository = lecturerJpaRepository;
        this.modelMapper= modelMapper;
    }


    @Override
    public List<Lecturer> getAllUsers() {
        var lecturerEntities = lecturerEntityRepository.findAll();
        var lecturers = lecturerEntities.stream().map(lecturerEntity -> modelMapper.map(lecturerEntity,Lecturer.class)).toList();
        return lecturers;
    }

    @Override
    public boolean existsByIdentity(Identity identity) {
        return lecturerEntityRepository.existsById(identity.getValue());
    }

    @Override
    public Optional<Lecturer> addUser(Lecturer lecturer) {
        if(existsByIdentity(lecturer.getIdentity())){
            return Optional.empty();
        }
        var lecturerEntity = modelMapper.map(lecturer, LecturerEntity.class);
        lecturerEntityRepository.save(lecturerEntity);
        return Optional.of(lecturer);
    }

    @Override
    public boolean removeUser(Lecturer lecturer) {
        if(existsByIdentity(lecturer.getIdentity())){
            var lecturerEntity = modelMapper.map(lecturer, LecturerEntity.class);
            lecturerEntityRepository.delete(lecturerEntity);
            return true;
        }
        return false;
    }

    @Override
    public Lecturer updateUser(Lecturer lecturer) {
        var lecturerEntity = modelMapper.map(lecturer, LecturerEntity.class);
        var updatedLecturerEntity = lecturerEntityRepository.save(lecturerEntity);
        var updatedLecturer = modelMapper.map(updatedLecturerEntity,Lecturer.class);
        return updatedLecturer;
    }

    @Override
    public Optional<Lecturer> findById(Identity identity) {
        return Optional.empty();
    }


}
