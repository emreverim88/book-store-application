package com.testinium.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testinium.entity.Book;
import com.testinium.entity.Category;
import com.testinium.repository.BookRepository;
import com.testinium.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBooks() {

		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	public List<Book> getBookById(Long categoryId) {

		Category category = new Category();
		category.setId(categoryId);
		return bookRepository.findByCategory(category);

	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void updateCategory(Long bookId, Long categoryId) {

		Book book = bookRepository.findById(bookId).get();
		Category category = new Category();
		category.setId(categoryId);
		book.setCategory(category);
		bookRepository.save(book);

	}

}
