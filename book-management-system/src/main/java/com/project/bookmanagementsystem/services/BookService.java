package com.project.bookmanagementsystem.services;

import com.project.bookmanagementsystem.Exception.BookNotFoundException;
import com.project.bookmanagementsystem.model.BookItem;
import com.project.bookmanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(BookItem book) {
        bookRepository.save(book);
    }
    public BookItem updateBook(String id, BookItem updateBookItem) {
        BookItem existingBookItem = bookRepository.findById(id).get();
        existingBookItem.setTitle(updateBookItem.getTitle() != null ? updateBookItem.getTitle(): existingBookItem.getTitle());
        existingBookItem.setAuthor(updateBookItem.getAuthor() != null ? updateBookItem.getAuthor() : existingBookItem.getAuthor());
        existingBookItem.setGenre(updateBookItem.getGenre() != null ? updateBookItem.getGenre() : existingBookItem.getGenre());
        existingBookItem.setDescription(updateBookItem.getDescription() != null ? updateBookItem.getDescription() : existingBookItem.getDescription());
        if(updateBookItem.getPrice() != 0.0) {
            existingBookItem.setPrice(updateBookItem.getPrice());

        }
        existingBookItem.setRating(updateBookItem.getRating() != 0.0 ? updateBookItem.getRating(): existingBookItem.getRating());

        System.out.println(
                updateBookItem.getRating() + " " + updateBookItem.getRating() + updateBookItem.getGenre()
        );

        bookRepository.save(existingBookItem);
        return updateBookItem;
    }
    public BookItem findBookById(String id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found of id: "+id));
    }
    public List<BookItem> findAll() {
        return bookRepository.findAll();
    }
    public void delete(String id){
        bookRepository.deleteById(id);
    }

}
