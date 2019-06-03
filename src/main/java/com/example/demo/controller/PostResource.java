package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	/**
	 * This method will return the text passed as path variable
	 * 
	 * @param message
	 * @return String
	 * 
	 */
	@GetMapping(path = "/post/{message}")
	public String inputPost(@PathVariable String message) {
		return message;
	}

}
