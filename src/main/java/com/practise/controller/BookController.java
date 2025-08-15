package com.practise.controller;

import com.practise.entity.Book;
import com.practise.service.BookService;
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

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        System.err.println(book);
        bookService.saveBook(book);
        return new ResponseEntity<>("Book Data Add Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllbooks")
    public ResponseEntity<List<Book>> getAllData(){
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
        String delete = bookService.deleteBookById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable ("id") int id, @RequestBody Book book){
        Book updateBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @PostMapping("/listOfBook")
    public ResponseEntity<List<Book>> savelistOfBooks(@RequestBody List<Book> bookList){
        bookService.savelistOfBook(bookList);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
