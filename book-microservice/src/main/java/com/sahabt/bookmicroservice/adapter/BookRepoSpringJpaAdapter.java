package com.sahabt.bookmicroservice.adapter;

import com.sahabt.bookmicroservice.entity.BookEntity;
import com.sahabt.bookmicroservice.repository.BookEntityRepository;
import domain.book.Book;
import domain.book.BookId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepoSpringJpaAdapter implements BookRepository {
    BookEntityRepository bookEntityRepository;
    ModelMapper modelMapper;


    public BookRepoSpringJpaAdapter(BookEntityRepository bookEntityRepository, ModelMapper modelMapper) {
        this.bookEntityRepository = bookEntityRepository;
        this.modelMapper= modelMapper;
    }


    @Override
    public List<Book> getAllBooks() {
        var bookEntities = bookEntityRepository.findAll();
        var books = bookEntities.stream().map(bookEntity -> modelMapper.map(bookEntity,Book.class)).toList();
        return books;
    }

    @Override
    public boolean existsByIdentity(BookId bookId) {
        return bookEntityRepository.existsById(bookId.getValue());
    }

    @Override
    public Optional<Book> addBook(Book book) {
        if(existsByIdentity(book.getBookId())){
            return Optional.empty();
        }
        var bookEntity = modelMapper.map(book, BookEntity.class);
        bookEntityRepository.save(bookEntity);
        return Optional.of(book);
    }

    @Override
    public boolean removeBook(Book book) {
        if(existsByIdentity(book.getBookId())){
            var bookEntity = modelMapper.map(book, BookEntity.class);
            bookEntityRepository.delete(bookEntity);
            return true;
        }
        return false;
    }

    @Override
    public Book updateBook(Book book) {
        var bookEntity = modelMapper.map(book, BookEntity.class);
        var updatedBookEntity = bookEntityRepository.save(bookEntity);
        var updatedBook = modelMapper.map(updatedBookEntity,Book.class);
        return updatedBook;
    }

    @Override
    public Optional<Book> findByBookId(BookId bookId) {
        var bookEntity = bookEntityRepository.findById(bookId.getValue());
        return Optional.of(modelMapper.map(bookEntity.get(),Book.class));
    }


}
