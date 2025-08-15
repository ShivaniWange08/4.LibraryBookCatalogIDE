package com.practise.service;

import com.practise.entity.Book;

import java.util.List;

public interface BookService {

    String saveBook(Book book);

    List<Book> getAllBook();

    Book getBookById(int id);

    String deleteBookById(int id);

    Book updateBook(int id, Book newBook);

    List<Book> savelistOfBook(List<Book> bookList);


}
