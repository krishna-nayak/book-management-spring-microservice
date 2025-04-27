package com.project.userservice.extranal.services;

import com.project.userservice.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookServices {
    @GetMapping("/book/{id}")
    public Book getBookId(@PathVariable("id") String id);

    @GetMapping("/book")
    public List<Book> getAllBookById();
}
