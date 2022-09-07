package com.sanedge.bookservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanedge.bookservice.dto.BookDto;
import com.sanedge.bookservice.entity.BookEntity;
import com.sanedge.bookservice.repository.BookRepository;
import com.sanedge.bookservice.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDto, bookEntity);
        bookEntity = bookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, bookDto);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if (optEntity.isPresent()) {
            be = optEntity.get();
            be = optEntity.get();
            be.setAuthorEmail(bookDto.getAuthorEmail());
            be.setAuthorName(bookDto.getAuthorName());
            be.setAvailableQty(bookDto.getAvailableQty());
            be.setDescription(bookDto.getDescription());
            be.setName(bookDto.getName());
            be.setPricePerQty(bookDto.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDto);
        return bookDto;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDto updateBookPrice(BookDto bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if (optEntity.isPresent()) {
            be = optEntity.get();
            be.setPricePerQty(bookDTO.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    @Override
    public List<BookDto> getAllBook() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDto> bookDtos = null;

        if (bookEntities != null && !bookEntities.isEmpty()) {// not null & not empty
            bookDtos = new ArrayList<>();
            BookDto dto = null;
            for (BookEntity be : bookEntities) {
                dto = new BookDto();
                BeanUtils.copyProperties(be, dto);
                bookDtos.add(dto);
            }
        }
        return bookDtos;
    }

    @Override
    public BookDto getBook(Long bookId) {
        Optional<BookEntity> optBook = bookRepository.findById(bookId);
        BookDto bookDto = null;
        if (optBook.isPresent()) {
            bookDto = new BookDto();
            BeanUtils.copyProperties(optBook.get(), bookDto);
        }

        return bookDto;
    }
}
