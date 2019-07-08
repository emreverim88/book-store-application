package com.testinium.service;

import java.util.List;

import com.testinium.entity.Book;
import com.testinium.entity.BookStore;

public interface BookStoreService {

	public List<BookStore> getBookStores();

	public void saveBookStore(BookStore bookStore);

	public List<BookStore> getBookStoreById(Long bookStoreId);

	public List<Book> getBookByBookStore(Long bookStoreId);

	public void deleteBookFromBookStore(Long bookStoreId, Long bookId);

	void addBookToBookStore(Long bookStoreId, Long bookId, int price);
}
