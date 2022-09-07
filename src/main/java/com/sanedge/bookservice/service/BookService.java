package com.sanedge.bookservice.service;

import java.util.List;

import com.sanedge.bookservice.dto.BookDto;

public interface BookService {
    public BookDto addBook(BookDto bookDto);

    public BookDto updateBook(BookDto bookDto, Long bookId);

    public void deleteBook(Long bookId);

    public BookDto updateBookPrice(BookDto bookDto, Long bookId);

    public List<BookDto> getAllBook();

    public BookDto getBook(Long bookId);
}
