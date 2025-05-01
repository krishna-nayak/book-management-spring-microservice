package com.project.bookmanagementsystem.controller;

import com.project.bookmanagementsystem.Exception.BookNotFoundException;
import com.project.bookmanagementsystem.model.BookItem;
import com.project.bookmanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public String initial(){
        return "work";
    }

    @GetMapping()
    public ResponseEntity<List<BookItem>> getBookList() {
         List<BookItem> books =  bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookItem> getBookByID(@PathVariable("id") String id) throws BookNotFoundException {
        BookItem book = bookService.findBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<String> getBookById(@PathVariable("id") String id){
//        return  ResponseEntity.ok("Id: "+id);
//    }

    @PostMapping()
    public ResponseEntity<String> addBookItem(@RequestBody BookItem bookItem) {
            bookService.saveBook(bookItem);
            return ResponseEntity.ok("ADDED BOOK");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookItem(@RequestBody BookItem bookItem, @PathVariable("id") String id) {
            bookService.updateBook(id, bookItem);
            return ResponseEntity.ok("Updated Book");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookItem(@PathVariable("id") String id) {
            bookService.delete(id);
            return ResponseEntity.ok("Deleted");
    }
}
