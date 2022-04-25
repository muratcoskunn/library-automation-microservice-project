package com.sahabt.studentmicroservice.repository;

import com.sahabt.studentmicroservice.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity,String> {
}
