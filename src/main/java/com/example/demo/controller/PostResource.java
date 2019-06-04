package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.PostRepository;
import com.example.demo.model.Post;

@RestController
public class PostResource {

	@Autowired
	PostRepository postRepository;

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
		Timestamp currentTime = new Timestamp(new Date().getTime());
		post.setTimestamp(currentTime);
		postRepository.save(post);

		return post.getInputMessage();
	}

}
