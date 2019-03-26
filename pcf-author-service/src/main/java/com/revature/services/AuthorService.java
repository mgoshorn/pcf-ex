package com.revature.services;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Author;
import com.revature.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Inject
	AuthorRepository authorRepository;
	
	public Author saveAuthor(Author author) {
		return this.authorRepository.save(author);
	}
	
	public Author getAuthor(int id) {
		return this.authorRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}