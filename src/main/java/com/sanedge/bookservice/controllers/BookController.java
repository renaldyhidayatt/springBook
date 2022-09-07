package com.sanedge.bookservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanedge.bookservice.dto.BookDto;
import com.sanedge.bookservice.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        bookDto = bookService.addBook(bookDto);
        ResponseEntity<BookDto> responseEntity = new ResponseEntity<BookDto>(bookDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBook();
        ResponseEntity<List<BookDto>> responseEntity = new ResponseEntity<>(books, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long bookId) {
        BookDto bookDTO = bookService.getBook(bookId);
        ResponseEntity<BookDto> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDTO, @PathVariable Long bookId) {
        bookDTO = bookService.updateBook(bookDTO, bookId);
        ResponseEntity<BookDto> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/books/{bookId}")
    public ResponseEntity<BookDto> updateBookPrice(@RequestBody BookDto bookDTO, @PathVariable Long bookId) {
        bookDTO = bookService.updateBookPrice(bookDTO, bookId);
        ResponseEntity<BookDto> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/books/{bookId}")
    public HttpStatus deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return HttpStatus.NO_CONTENT;
    }
}
