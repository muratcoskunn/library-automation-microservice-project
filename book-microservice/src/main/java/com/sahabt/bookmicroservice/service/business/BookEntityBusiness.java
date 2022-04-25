package com.sahabt.bookmicroservice.service.business;

import application.BookApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahabt.bookmicroservice.entity.BookEntity;
import com.sahabt.bookmicroservice.service.BookEntityService;
import domain.book.Book;
import domain.book.BookId;
import domain.user.Identity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class BookEntityBusiness implements BookEntityService {
    BookApplication bookApplication;
    ModelMapper modelMapper;
    @Autowired
    ObjectMapper objectMapper;

    public BookEntityBusiness(BookApplication bookApplication,ModelMapper modelMapper) {
        this.bookApplication = bookApplication;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        var bookEntities = bookApplication.getAllBooks().stream().map(book -> modelMapper.map(book,BookEntity.class)).toList();
        return bookEntities;
    }

    @Override
    public Optional<BookEntity> addBook(BookEntity bookEntity) {
        var book = modelMapper.map(bookEntity, Book.class);
        var addedBook = bookApplication.addBook(book);
        return Optional.of(modelMapper.map(addedBook.get(),BookEntity.class));
    }

    @Override
    public Optional<BookEntity> updateBook(BookEntity bookEntity) {
        var book = modelMapper.map(bookEntity,Book.class);
        var updatedBook = bookApplication.updateBook(book);
        if(updatedBook.isPresent()){
            var updatedBookEntity = modelMapper.map(updatedBook.get(),BookEntity.class);
            return Optional.of(updatedBookEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean removeBook(BookEntity bookEntity) {
        var book = modelMapper.map(bookEntity,Book.class);
        return bookApplication.removeBook(book);
    }

    @Override
    public BookEntity findByBookId(String bookId) {
        var book = bookApplication.findByBookId(BookId.of(bookId)).orElseThrow(()->new IllegalArgumentException("Book could not have found"));
        return modelMapper.map(book,BookEntity.class);
    }

    @Override
    public String getBookByBookId(String id) throws JsonProcessingException {
        System.err.println(id);
        return objectMapper.writeValueAsString(bookApplication.findByBookId(BookId.of(id)).get());
    }

    @Override
    public Boolean existsById(String id) {
        return bookApplication.existsById(BookId.of(id));
    }
}
