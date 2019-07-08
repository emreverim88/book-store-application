package com.testinium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testinium.entity.Book;
import com.testinium.entity.BookStore;
import com.testinium.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	List<Price> findByBookStore(BookStore bookStore);

	Price findByBookStoreAndBook(BookStore bookStore, Book book);

}
