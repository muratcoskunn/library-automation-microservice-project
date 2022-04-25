package com.sahabt.lecturermicroservice.service;

import com.sahabt.lecturermicroservice.entity.LecturerEntity;

import java.util.List;
import java.util.Optional;

public interface LecturerService {

    List<LecturerEntity> getAllLecturers();

    Optional<LecturerEntity> addLecturer(LecturerEntity lecturerEntity);

    Optional<LecturerEntity> updateLecturer(LecturerEntity lecturerEntity);

    boolean removeLecturer(LecturerEntity lecturerEntity);

    Boolean existsById(String id);
}
