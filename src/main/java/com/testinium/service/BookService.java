package com.testinium.service;

import java.util.List;

import com.testinium.entity.Book;

public interface BookService {

	public List<Book> getBooks();

	public void saveBook(Book book);

	public List<Book> getBookById(Long categoryId);

	public void updateCategory(Long bookId, Long categoryId);

}
