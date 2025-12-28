package com.project.bookmanagementsystem.services;

import com.project.bookmanagementsystem.Exception.BookNotFoundException;
import com.project.bookmanagementsystem.model.BookItem;
import com.project.bookmanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<BookItem> existingBookItem = bookRepository.findById(id);
        if(existingBookItem.isPresent()) {
            BookItem bookItem = existingBookItem.get();
            bookItem.setTitle(updateBookItem.getTitle() != null ? updateBookItem.getTitle() : bookItem.getTitle());
            bookItem.setAuthor(updateBookItem.getAuthor() != null ? updateBookItem.getAuthor() : bookItem.getAuthor());
            bookItem.setGenre(updateBookItem.getGenre() != null ? updateBookItem.getGenre() : bookItem.getGenre());
            bookItem.setDescription(updateBookItem.getDescription() != null ? updateBookItem.getDescription() : bookItem.getDescription());
            if (updateBookItem.getPrice() != 0.0) {
                bookItem.setPrice(updateBookItem.getPrice());

            }
            bookItem.setRating(updateBookItem.getRating() != 0.0 ? updateBookItem.getRating() : bookItem.getRating());
            bookRepository.save(bookItem);
        }
        System.out.println(
                updateBookItem.getRating() + " " + updateBookItem.getRating() + updateBookItem.getGenre()
        );

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
