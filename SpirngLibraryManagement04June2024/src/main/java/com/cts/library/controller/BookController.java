package com.cts.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.library.entity.Book;
import com.cts.library.service.BooksService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BooksService booksService; 
	
	@GetMapping("/allbooks")
	public ResponseEntity<List<Book>> allBooks(){
		
		List<Book> response = booksService.AllBooks();
		return new ResponseEntity<List<Book>>(response,HttpStatus.OK); 
	}
	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveProduct(@RequestBody Book book){
		Book response = booksService.save(book);
				
		return new ResponseEntity<Book>(response,HttpStatus.OK); 
	}

	
	@GetMapping("/getBookByTitle/{title}")
	public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
	
		Book response=booksService.getBookByTitle(title);
		
		return new ResponseEntity<Book>(response,HttpStatus.OK); 
	}
	
	@GetMapping("/getAvailableBooks")
	public ResponseEntity<List<Book>> getAvailableBook(){
	
		List<Book> response=booksService.getAvailableBooks();
		
		return new ResponseEntity<List<Book>>(response,HttpStatus.OK); 
	}
	
	@GetMapping("/getBorrowedBooks")
	public ResponseEntity<List<Book>> getBorrowedBook(){
	
		List<Book> response=booksService.getBorrowedBooks();
		
		return new ResponseEntity<List<Book>>(response,HttpStatus.OK); 
	}
	@PutMapping("/borrowBook/{id}")
	public ResponseEntity<Book> borrowBook(@PathVariable("id") Long id){
		Book response = booksService.borrowBook(id);
				
		return new ResponseEntity<Book>(response,HttpStatus.OK); 
	}
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id){
		String response = booksService.deleteBook(id);
				
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
}
