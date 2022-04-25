package com.sahabt.bookmicroservice.controller;

import com.sahabt.bookmicroservice.entity.BookEntity;
import com.sahabt.bookmicroservice.service.BookEntityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin
@RequestScope
public class BookEntityController {
    BookEntityService bookService;

    public BookEntityController(BookEntityService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookEntity> getAll(){
        return bookService.getAllBooks();
    }
    @PostMapping
    public Optional<BookEntity> addBook(@RequestBody BookEntity bookEntity){
        return bookService.addBook(bookEntity);
    }
    @PutMapping
    public Optional<BookEntity> updateBook(@RequestBody BookEntity bookEntity){
        return bookService.updateBook(bookEntity);
    }
    @DeleteMapping
    public boolean deleteBook(@RequestBody BookEntity bookEntity){
        return bookService.removeBook(bookEntity);
    }
    @GetMapping("/findById/{id}")
    public BookEntity findById(@PathVariable("id") String id){
        return bookService.findByBookId(id);
    }
    @GetMapping("/existsById/{id}")
    public Boolean existsById(@PathVariable("id") String id){
        return bookService.existsById(id);
    }
}
