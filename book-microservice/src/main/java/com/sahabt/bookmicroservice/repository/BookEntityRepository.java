package com.sahabt.bookmicroservice.repository;

import com.sahabt.bookmicroservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity,String> {
}
