package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;

@RestController
public class PostResource {

	List<Post> posts = new ArrayList<>();

	/**
	 * This method will return the text passed as path variable
	 * 
	 * @param message
	 * @return String
	 * 
	 */
	@PostMapping(path = "/postMessage")
	public String inputPost(@RequestBody Post post) {
		if (post == null || StringUtils.isEmpty(post.getInputMessage()))
			return "";
		posts.add(post);
		return post.getInputMessage();
	}

}
