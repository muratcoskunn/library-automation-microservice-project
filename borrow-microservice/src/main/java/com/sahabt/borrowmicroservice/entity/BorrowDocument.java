package com.sahabt.borrowmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "borrows")
public class BorrowDocument {
    @Id
    private String identity;
    private String userId;
    private String bookId;
}
