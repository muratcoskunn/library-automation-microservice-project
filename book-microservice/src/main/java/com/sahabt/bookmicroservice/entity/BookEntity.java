package com.sahabt.bookmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "books")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    private String identity;
    private String isbn;
    private String name;
    private String author;
    private int page;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return page == that.page && year == that.year && Objects.equals(identity, that.identity) && Objects.equals(isbn, that.isbn) && Objects.equals(name, that.name) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity);
    }
}
