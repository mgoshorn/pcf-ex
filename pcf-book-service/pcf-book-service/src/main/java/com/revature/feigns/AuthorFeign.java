package com.revature.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.dtos.AuthorDTO;

@Component
@FeignClient("author-service")
public interface AuthorFeign {

	@GetMapping("{id}")
	public AuthorDTO getAuthor(@PathVariable int id);
	
}
