package com.sahabt.officermicroservice.repository;

import com.sahabt.officermicroservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepo extends JpaRepository<BookEntity,String> {
}
