package com.project.bookmanagementsystem.controller;

import com.project.bookmanagementsystem.Exception.BookNotFoundException;
import com.project.bookmanagementsystem.dto.BookRequest;
import com.project.bookmanagementsystem.dto.BookResponse;
import com.project.bookmanagementsystem.mapper.BookMapper;
import com.project.bookmanagementsystem.model.BookItem;
import com.project.bookmanagementsystem.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    BookController(BookService bookService, BookMapper bookMapper){
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/test")
    public String initial(){
        return "Book API is running. Use /api/books instead of /book";
    }

    @GetMapping()
    public ResponseEntity<List<BookResponse>> getBookList() {

        List<BookResponse> books =  bookService.findAll()
                 .stream()
                 .map(bookMapper::toResponse)
                 .toList();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") String id) throws BookNotFoundException {
        BookResponse book = bookMapper.toResponse(bookService.findBookById(id));
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping()
    public ResponseEntity<String> addBookItem(@Valid @RequestBody BookRequest request) {
        BookItem entity = bookMapper.toEntity(request);
        bookService.saveBook(entity);
        return ResponseEntity.ok("ADDED BOOK");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookItem(@PathVariable("id") String id, @RequestBody BookRequest request) {
            var entity = bookMapper.toEntity(request);
            bookService.updateBook(id, entity);
            return ResponseEntity.ok("Updated Book");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookItem(@PathVariable("id") String id) {
            bookService.delete(id);
            return ResponseEntity.ok("Deleted");
    }
}
