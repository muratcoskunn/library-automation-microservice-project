package com.sahabt.borrowmicroservice.service;

import com.sahabt.borrowmicroservice.dto.BorrowRequest;
import com.sahabt.borrowmicroservice.entity.BorrowDocument;

public interface BorrowService {
    BorrowDocument borrow(BorrowRequest borrowRequest);
}
