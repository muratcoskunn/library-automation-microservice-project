package com.sahabt.lecturermicroservice.repository;

import com.sahabt.lecturermicroservice.entity.LecturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerEntityRepository extends JpaRepository<LecturerEntity,String> {

}
