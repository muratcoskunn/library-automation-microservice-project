package com.sahabt.borrowmicroservice.controller;

import com.sahabt.borrowmicroservice.dto.BorrowRequest;
import com.sahabt.borrowmicroservice.entity.BorrowDocument;
import com.sahabt.borrowmicroservice.service.BorrowService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/borrow")
@RequestScope
@CrossOrigin
public class BorrowController {
    BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }
    @PostMapping
    public BorrowDocument borrow(@RequestBody BorrowRequest borrowRequest){
        return borrowService.borrow(borrowRequest);
    }
}
