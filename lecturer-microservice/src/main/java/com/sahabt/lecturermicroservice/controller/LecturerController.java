package com.sahabt.lecturermicroservice.controller;

import com.sahabt.lecturermicroservice.dto.LecturerEntityRequest;
import com.sahabt.lecturermicroservice.entity.LecturerEntity;
import com.sahabt.lecturermicroservice.service.LecturerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecturers")
@CrossOrigin
@RequestScope
public class LecturerController {
    LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public List<LecturerEntity> getAll(){
        return lecturerService.getAllLecturers();
    }
    @PostMapping
    public Optional<LecturerEntity> addLecturer(@RequestBody LecturerEntity lecturerEntity){
        return lecturerService.addLecturer(lecturerEntity);
    }
    @PutMapping
    public Optional<LecturerEntity> updateLecturer(@RequestBody LecturerEntity lecturerEntity){
        return lecturerService.updateLecturer(lecturerEntity);
    }
    @DeleteMapping
    public void deleteLecturer(@RequestBody LecturerEntity lecturerEntity){
        lecturerService.removeLecturer(lecturerEntity);
    }
    @GetMapping("existsById/{id}")
    public Boolean existsById(@PathVariable String id){
        return lecturerService.existsById(id);
    }
}
