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

import com.revature.models.Author;
import com.revature.services.AuthorService;

@RestController
@RequestMapping("")
public class AuthorController {

	@Inject
	AuthorService authorService;
	
	@GetMapping("/{id}")
	public Author getAuthor(@PathVariable int id) {
		System.out.println("Getting author");
		return authorService.getAuthor(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Author saveAuthor(@RequestBody Author author) {
		System.out.println("Saving author");
		return authorService.saveAuthor(author);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> clientErrorHandler(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}