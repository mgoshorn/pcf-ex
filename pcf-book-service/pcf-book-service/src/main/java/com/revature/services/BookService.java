package com.revature.services;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dtos.AuthorDTO;
import com.revature.feigns.AuthorFeign;
import com.revature.models.Book;
import com.revature.repositories.BookRepository;

@Service
public class BookService {

	@Inject
	BookRepository bookRepository;
	
	@Inject
	AuthorFeign authorFeign;
	
	public Book saveBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	public Book getBook(int id) {
		Book book = this.bookRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		AuthorDTO authorDTO = authorFeign.getAuthor(book.getAuthorId());
		book.setAuthor(authorDTO);
		return book;
	}
}
