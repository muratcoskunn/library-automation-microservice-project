package com.sahabt.officermicroservice.controller;

import com.sahabt.officermicroservice.dto.request.BorrowRequest;
import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.entity.OfficerEntity;
import com.sahabt.officermicroservice.service.OfficerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/officers")
@RequestScope
@CrossOrigin
public class OfficerController {
    OfficerService officerService;

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }
    @GetMapping
    public List<OfficerEntity> getAllOfficers(){
        return officerService.getAllOfficers();
    }
    @PostMapping
    public Optional<OfficerEntity> addOfficer(@RequestBody OfficerEntity officerEntity){
        return officerService.addOfficer(officerEntity);
    }
    @PutMapping
    public Optional<OfficerEntity> updateOfficer(@RequestBody OfficerEntity officerEntity){
        return officerService.updateOfficer(officerEntity);
    }
    @DeleteMapping
    public boolean removeOfficer(@RequestBody OfficerEntity officerEntity){
        return officerService.removeOfficer(officerEntity);
    }
}
