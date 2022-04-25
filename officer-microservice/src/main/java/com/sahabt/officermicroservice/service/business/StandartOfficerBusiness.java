package com.sahabt.officermicroservice.service.business;

import application.UserApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahabt.officermicroservice.dto.BookDto;
import com.sahabt.officermicroservice.dto.request.BorrowRequest;
import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.entity.OfficerEntity;
import com.sahabt.officermicroservice.repository.BookEntityRepo;
import com.sahabt.officermicroservice.repository.OfficerEntityRepository;
import com.sahabt.officermicroservice.service.OfficerService;
import domain.book.Book;
import domain.user.Officer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StandartOfficerBusiness implements OfficerService {
    UserApplication userApplication;
    ModelMapper modelMapper;
    @Autowired
    OfficerEntityRepository officerEntityRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BookEntityRepo bookEntityRepo;


    public StandartOfficerBusiness(UserApplication userApplication, ModelMapper modelMapper) {
        this.userApplication = userApplication;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<OfficerEntity> getAllOfficers() {
        var officerEntities = userApplication.getAllUsers().stream().map(officer -> modelMapper.map(officer,OfficerEntity.class)).toList();
        return officerEntities;
    }

    @Override
    public Optional<OfficerEntity> addOfficer(OfficerEntity officerEntity) {
        var officer = modelMapper.map(officerEntity,Officer.class);
        var addedOfficer = userApplication.addUser(officer);
        return Optional.of(modelMapper.map(addedOfficer.get(),OfficerEntity.class));
    }

    @Override
    public Optional<OfficerEntity> updateOfficer(OfficerEntity officerEntity) {
        var officer = modelMapper.map(officerEntity,Officer.class);
        var updatedOfficer = userApplication.updateUser(officer);
        if(updatedOfficer.isPresent()){
            var updatedOfficerEntity = modelMapper.map(updatedOfficer.get(),OfficerEntity.class);
            return Optional.of(updatedOfficerEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean removeOfficer(OfficerEntity officerEntity) {
        var officer = modelMapper.map(officerEntity,Officer.class);
        return userApplication.removeUser(officer);
    }


}
