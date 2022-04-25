package com.sahabt.bookmicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sahabt.bookmicroservice.entity.BookEntity;
import domain.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookEntityService {

    List<BookEntity> getAllBooks();

    Optional<BookEntity> addBook(BookEntity bookEntity);

    Optional<BookEntity> updateBook(BookEntity bookEntity);

    boolean removeBook(BookEntity bookEntity);

    BookEntity findByBookId(String bookId);

    String getBookByBookId(String id) throws JsonProcessingException;

    Boolean existsById(String id);
}
