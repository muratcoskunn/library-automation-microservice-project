package com.sahabt.borrowmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    private String identity;
    private String isbn;
    private String name;
    private String author;
    private int page;
    private int year;
}
