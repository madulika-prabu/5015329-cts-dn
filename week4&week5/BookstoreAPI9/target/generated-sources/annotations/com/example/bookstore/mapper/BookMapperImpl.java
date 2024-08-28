package com.example.bookstore.mapper;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T12:13:22+0530",
    comments = "version: 1.5.0.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 22.0.1 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setId( book.getId() );
        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setTitle( book.getTitle() );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookDTO.getAuthor() );
        book.setId( bookDTO.getId() );
        book.setPrice( bookDTO.getPrice() );
        book.setTitle( bookDTO.getTitle() );

        return book;
    }
}
