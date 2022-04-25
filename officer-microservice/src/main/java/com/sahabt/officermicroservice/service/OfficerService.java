package com.sahabt.officermicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sahabt.officermicroservice.dto.request.BorrowRequest;
import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.entity.OfficerEntity;
import com.sahabt.officermicroservice.repository.BookEntityRepo;
import domain.book.Book;

import java.util.List;
import java.util.Optional;

public interface OfficerService {
    List<OfficerEntity> getAllOfficers();

    Optional<OfficerEntity> addOfficer(OfficerEntity officerEntity);

    Optional<OfficerEntity> updateOfficer(OfficerEntity officerEntity);

    boolean removeOfficer(OfficerEntity officerEntity);

}
