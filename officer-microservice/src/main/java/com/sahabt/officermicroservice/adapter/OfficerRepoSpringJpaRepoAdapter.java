package com.sahabt.officermicroservice.adapter;

import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.entity.OfficerEntity;
import com.sahabt.officermicroservice.repository.OfficerEntityRepository;
import domain.book.Book;
import domain.user.Identity;
import domain.user.Officer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserCrudRepository;

import java.util.List;
import java.util.Optional;

@Component
public class OfficerRepoSpringJpaRepoAdapter implements UserCrudRepository<Officer> {
    OfficerEntityRepository officerEntityRepository;
    @Autowired
    ModelMapper modelMapper;

    public OfficerRepoSpringJpaRepoAdapter(OfficerEntityRepository officerEntityRepository) {
        this.officerEntityRepository = officerEntityRepository;
    }


    @Override
    public List<Officer> getAllUsers() {
        var officerEntities = officerEntityRepository.findAll();
        var officers = officerEntities.stream().map(officerEntity -> modelMapper.map(officerEntity,Officer.class)).toList();
        return officers;
    }

    @Override
    public boolean existsByIdentity(Identity identity) {
        return officerEntityRepository.existsById(identity.getValue());
    }

    @Override
    public Optional<Officer> addUser(Officer officer) {
        if(existsByIdentity(officer.getIdentity())){
            return Optional.empty();
        }
        var officerEntity = modelMapper.map(officer, OfficerEntity.class);
        officerEntityRepository.save(officerEntity);
        return Optional.of(officer);
    }

    @Override
    public boolean removeUser(Officer officer) {
        if(existsByIdentity(officer.getIdentity())){
            var officerEntity = modelMapper.map(officer, OfficerEntity.class);
            officerEntityRepository.delete(officerEntity);
            return true;
        }
        return false;
    }

    @Override
    public Officer updateUser(Officer officer) {
        var officerEntity = modelMapper.map(officer, OfficerEntity.class);
        var updatedOfficerEntity = officerEntityRepository.save(officerEntity);
        var updatedOfficer = modelMapper.map(updatedOfficerEntity,Officer.class);
        return updatedOfficer;
    }

    @Override
    public Optional<Officer> findById(Identity identity) {
        var officerEntity = officerEntityRepository.findById(identity.getValue());
        if(officerEntity.isPresent())
            return Optional.of(modelMapper.map(officerEntity.get(),Officer.class));
        return Optional.empty() ;
    }

}
