package com.sahabt.bookmicroservice.configuration;

import com.sahabt.bookmicroservice.entity.BookEntity;
import domain.book.Book;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static final Converter<BookEntity, Book> BOOK_ENTITY_TO_BOOK_CONVERTER = (context) ->{return
            new Book.Builder().bookId(context.getSource().getIdentity())
                    .isbn(context.getSource().getIsbn())
                    .bookName(context.getSource().getName()).author(context.getSource().getAuthor())
                    .page(context.getSource().getPage()).year(context.getSource().getYear()).build();};
    private static final Converter<Book,BookEntity> BOOK_TO_BOOK_ENTITY_CONVERTER = (context) ->{return
            new BookEntity(context.getSource().getBookId().getValue(),
                    context.getSource().getIsbn().getIsbn(),
                    context.getSource().getBookName().getValue(),
                    context.getSource().getAuthor().getValue(),
                    context.getSource().getPage().getValue(),
                    context.getSource().getYear().getValue());};
    @Bean
    public ModelMapper createModelMapper(){
        var modelMapper= new ModelMapper();
        modelMapper.addConverter(BOOK_ENTITY_TO_BOOK_CONVERTER,BookEntity.class,Book.class);
        modelMapper.addConverter(BOOK_TO_BOOK_ENTITY_CONVERTER,Book.class,BookEntity.class);
        return modelMapper;
    }
}
