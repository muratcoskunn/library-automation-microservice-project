package com.sahabt.officermicroservice.repository;

import com.sahabt.officermicroservice.entity.OfficerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerEntityRepository extends JpaRepository<OfficerEntity,String> {
}
