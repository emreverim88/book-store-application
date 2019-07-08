package com.testinium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.testinium.entity.BookStore;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

	@Query("select u from BookStore u where u.id = :bookStoreId")
	List<BookStore> findByBookStoreId(@Param("bookStoreId") Long bookStoreId);

}
