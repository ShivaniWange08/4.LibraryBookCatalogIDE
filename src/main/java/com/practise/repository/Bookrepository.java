package com.practise.repository;

import com.practise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepository extends JpaRepository<Book, Integer> {

}
