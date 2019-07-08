package com.testinium.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.entity.Book;
import com.testinium.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {

		List<Book> books = bookService.getBooks();
		return books;

	}

	@GetMapping("/category/{categoryId}")
	public List<Book> getBooks(@PathVariable(name = "categoryId") Long categoryId) {

		return bookService.getBookById(categoryId);

	}

	@PostMapping
	public void saveCategory(@Valid @RequestBody Book book) {

		bookService.saveBook(book);

	}

	@PostMapping("/{bookStoreId}")
	public void saveCategory(@Valid @RequestBody Book book, @Valid @RequestBody Long bookStoreId) {
		bookService.saveBook(book);

	}

	@PutMapping("/{bookId}/category/{categoryId}")
	public void updateCategory(@PathVariable(name = "bookId") Long bookId,
			@PathVariable(name = "categoryId") Long categoryId) {

		bookService.updateCategory(bookId, categoryId);

	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
