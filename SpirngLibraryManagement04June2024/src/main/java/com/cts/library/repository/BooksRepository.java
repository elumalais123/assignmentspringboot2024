package com.cts.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.library.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

	Book getBookByTitle(String title); 
	
	@Query(value = "select * from book where borrowed=?1", nativeQuery=true)
	List<Book> getBookByStatus(boolean borrowed); 
}
