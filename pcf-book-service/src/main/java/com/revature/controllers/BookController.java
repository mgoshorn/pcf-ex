package com.revature.controllers;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Book;
import com.revature.services.BookService;

@RestController
@RequestMapping("")
public class BookController {

	@Inject
	BookService bookService;

	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> clientErrorHandler(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
