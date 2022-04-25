package com.sahabt.borrowmicroservice.repository;

import com.sahabt.borrowmicroservice.entity.BorrowDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowMongoRepository extends MongoRepository<BorrowDocument,Long> {
}
