package com.cts.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.library.entity.Book;
import com.cts.library.repository.BooksRepository;

@Service
public class BooksService {

	private BooksRepository booksRepository;

	public BooksService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	public List<Book> AllBooks(){
		return booksRepository.findAll();
	}
	
	public Book getBookByTitle(String title) {
		
		return booksRepository.getBookByTitle(title);
	}
	
	public List<Book> getAvailableBooks(){
		return booksRepository.getBookByStatus(false);
	}
	
	public List<Book> getBorrowedBooks(){
		return booksRepository.getBookByStatus(true);
	}
	
	public Book save(Book book) {

		return booksRepository.save(book);
	}

	public Book borrowBook(Long id) {
		Book book=booksRepository.findById(id).get();
		book.setBorrowed(true);
		booksRepository.save(book);
		
		
		return book;
	}

	public String deleteBook(Long id) {

		booksRepository.deleteById(id);

		return "Book Deleted";
	}
}
