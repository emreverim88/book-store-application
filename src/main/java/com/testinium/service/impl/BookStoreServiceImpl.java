package com.testinium.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testinium.entity.Book;
import com.testinium.entity.BookStore;
import com.testinium.entity.Price;
import com.testinium.repository.BookStoreRepository;
import com.testinium.repository.PriceRepository;
import com.testinium.service.BookStoreService;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	private BookStoreRepository bookStoreRepository;

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public List<BookStore> getBookStores() {
		List<BookStore> bookStores = bookStoreRepository.findAll();
		return bookStores;
	}

	@Override
	public void saveBookStore(BookStore bookStore) {
		bookStoreRepository.save(bookStore);

	}

	@Override
	public List<BookStore> getBookStoreById(Long bookStoreId) {
		return bookStoreRepository.findByBookStoreId(bookStoreId);
	}

	public BookStoreRepository getBookStoreRepository() {
		return bookStoreRepository;
	}

	public void setBookStoreRepository(BookStoreRepository bookStoreRepository) {
		this.bookStoreRepository = bookStoreRepository;
	}

	@Override
	public void addBookToBookStore(Long bookStoreId, Long bookId, int price) {

		BookStore bookStore = new BookStore();
		Book book = new Book();
		bookStore.setId(bookStoreId);
		book.setId(bookId);

		Price p = priceRepository.findByBookStoreAndBook(bookStore, book);

		if (p == null) {
			p = new Price();
			p.setBook(book);
			p.setBookStore(bookStore);
			p.setPrice(price);

		} else {

			p.setPrice(price);

		}

		priceRepository.save(p);

	}

	@Override
	public List<Book> getBookByBookStore(Long bookStoreId) {

		BookStore bookStore = new BookStore();
		bookStore.setId(bookStoreId);
		List<Book> books = new ArrayList<>();

		List<Price> prices = priceRepository.findByBookStore(bookStore);
		for (Price price : prices) {

			books.add(price.getBook());

		}
		return books;

	}

	@Override
	public void deleteBookFromBookStore(Long bookStoreId, Long bookId) {

		BookStore bookStore = new BookStore();
		Book book = new Book();
		bookStore.setId(bookStoreId);
		book.setId(bookId);

		Price p = priceRepository.findByBookStoreAndBook(bookStore, book);
		priceRepository.delete(p);
	}

}
