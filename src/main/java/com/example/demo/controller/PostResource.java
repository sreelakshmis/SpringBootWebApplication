package com.example.demo.controller;

import static org.springframework.util.StringUtils.isEmpty;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.PostRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.wrapper.PostWrapper;

@RestController
public class PostResource {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository UserRepository;

	/**
	 * This method will return the text passed as path variable
	 * 
	 * @param message
	 * @return String
	 * 
	 */
	@PostMapping(path = "/postMessage")
	public String inputPost(@RequestBody Post post) {
		if (post == null || isEmpty(post.getInputMessage()))
			return "";
		Timestamp currentTime = new Timestamp(new Date().getTime());
		post.setTimestamp(currentTime);
		postRepository.save(post);

		return post.getInputMessage();
	}
  
	@PostMapping(path = "/postListMessageForUser")
	public void createPostListForUser(@RequestBody PostWrapper postWrapper) {
		if (postWrapper == null)
			return;

		List<String> messsages = postWrapper.getInputMessageList();
		String firstName = postWrapper.getFirstName();
		String lastName = postWrapper.getLastName();
        
		if(isEmpty(firstName)||isEmpty(lastName) || CollectionUtils.isEmpty(messsages))
			return;
		
		// insert User and get the Id back
		User newUser = UserRepository.save(new User(firstName, lastName));

		// insert post with the user id
		Timestamp currentTime = new Timestamp(new Date().getTime());
		for (String newPostMessage : messsages) {
			postRepository.save(new Post(newPostMessage, currentTime, newUser));
		}
	}
	
	@GetMapping(path = "/getAllMessages")
	public List<Post> inputAllMessages() {
		List<Post> post = postRepository.findAll();
		return post;
	}
}
