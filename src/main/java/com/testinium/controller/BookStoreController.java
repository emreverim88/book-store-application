package com.testinium.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.entity.Book;
import com.testinium.entity.BookStore;
import com.testinium.service.BookStoreService;

@RestController
@RequestMapping("/api/book-stores")
public class BookStoreController {

	@Autowired
	private BookStoreService bookStoreService;

	@GetMapping
	public List<BookStore> getBookStores() {

		List<BookStore> bookStores = bookStoreService.getBookStores();
		return bookStores;

	}

	@GetMapping("/{bookStoreId}")
	public List<BookStore> getBookStoreById(@PathVariable(name = "bookStoreId") Long bookStoreId) {

		List<BookStore> bookStore = bookStoreService.getBookStoreById(bookStoreId);

		return bookStore;

	}

	@GetMapping("/{bookStoreId}/books")
	public List<Book> getBookByBookStore(@PathVariable(name = "bookStoreId") Long bookStoreId) {

		return bookStoreService.getBookByBookStore(bookStoreId);

	}

	@PostMapping
	public void saveCategory(@Valid @RequestBody BookStore bookStore) {

		bookStoreService.saveBookStore(bookStore);

	}

	@PostMapping("/{bookStoreId}/add-book/{bookId}/price/{price}")
	public void addBookToBookStore(@PathVariable(name = "bookStoreId") Long bookStoreId,
			@PathVariable(name = "bookId") Long bookId, @PathVariable(name = "price") Integer price) {

		bookStoreService.addBookToBookStore(bookStoreId, bookId, price);

	}

	@DeleteMapping("/{bookStoreId}/add-book/{bookId}")
	public void deleteBookFromBookStore(@PathVariable(name = "bookStoreId") Long bookStoreId,
			@PathVariable(name = "bookId") Long bookId) {

		bookStoreService.deleteBookFromBookStore(bookStoreId, bookId);

	}

	public BookStoreService getBookStoreService() {
		return bookStoreService;
	}

	public void setBookStoreService(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}

}
