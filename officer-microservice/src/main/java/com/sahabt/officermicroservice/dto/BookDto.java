package com.sahabt.officermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String identity;
    private String isbn;
    private String name;
    private String author;
    private int page;
    private int year;
}
