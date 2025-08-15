package com.practise.serviceimpl;

import com.practise.entity.Book;
import com.practise.repository.Bookrepository;
import com.practise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {

    @Autowired
    private Bookrepository bookrepository;

    @Override
    public String saveBook(Book book) {
        Book savedBook = bookrepository.save(book);
        return "book saved";
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = bookrepository.findAll();
        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        Book book = bookrepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Book with id not found" +id));
        return book;
    }

    @Override
    public String deleteBookById(int id) {
        bookrepository.deleteById(id);
        return "Book Deleted";
    }

    @Override
    public Book updateBook(int id, Book newBook) {
        Book book =  bookrepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Book with id not found in database" +id));
        System.err.println("old books from db " +book);
        System.err.println("Book object with value to be updated" +newBook);
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setIsbn(newBook.getIsbn());
        book.setAvailableCopies(newBook.getAvailableCopies());

        Book updateBook = bookrepository.save(book);
        System.err.println("Book with updated value :"+updateBook);
        return updateBook;
    }

    @Override
    public List<Book> savelistOfBook(List<Book> bookList) {
        bookrepository.saveAll(bookList);
        return bookList;
    }
}
