package com.sahabt.officermicroservice.config;

import com.sahabt.officermicroservice.dto.BookDto;
import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.entity.OfficerEntity;
import domain.book.Book;
import domain.user.Officer;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    private static final Converter<OfficerEntity, Officer> OFFICER_ENTITY_TO_OFFICER_CONVERTER =
            context -> { var officerEntity =context.getSource();
        return new Officer.Builder()
                .identity(officerEntity.getOfficerId())
                .fullname(officerEntity.getName(), officerEntity.getSurname())
                .department(officerEntity.getDepartment()).OfficerBook(officerEntity.getBookEntity().getIdentity())
                .build();
    };
    private static final Converter<Officer,OfficerEntity> OFFICER_TO_OFFICER_ENTITY_CONVERTER = context -> {
        var officer = context.getSource();
        return new OfficerEntity(officer.getIdentity().getValue(),
                officer.getFullName().getName(),
                officer.getFullName().getSurname(),
                officer.getDepartment().getValue(),new BookEntity(context.getSource().getOfficerBook().getBookId()));
    };
    private static final Converter<BookDto, Book> BOOK_DTO_BOOK_CONVERTER = (context) ->{return
            new Book.Builder().bookId(context.getSource().getIdentity())
                    .isbn(context.getSource().getIsbn())
                    .bookName(context.getSource().getName()).author(context.getSource().getAuthor())
                    .page(context.getSource().getPage()).year(context.getSource().getYear()).build();};
    @Bean
    public ModelMapper createModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(OFFICER_ENTITY_TO_OFFICER_CONVERTER,OfficerEntity.class,Officer.class);
        modelMapper.addConverter(OFFICER_TO_OFFICER_ENTITY_CONVERTER,Officer.class,OfficerEntity.class);
        modelMapper.addConverter(BOOK_DTO_BOOK_CONVERTER,BookDto.class,Book.class);
        return modelMapper;
    }
}
