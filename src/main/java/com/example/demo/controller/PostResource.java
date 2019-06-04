package com.example.demo.controller;

import static org.springframework.util.StringUtils.isEmpty;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.CommentRepository;
import com.example.demo.data.PostRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.exception.MissingRequiredInputException;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.wrapper.CommentWrapper;
import com.example.demo.wrapper.PostWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class PostResource {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository UserRepository;

	@Autowired
	CommentRepository commentRepository;

	WeatherResource weatherResource = new WeatherResource();

	/**
	 * This method will return the text passed as POST request
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

	/**
	 * Method that will save the list of post messages for the corresponding user
	 * 
	 * @param postWrapper
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@PostMapping(path = "/postListMessageForUser")
	public void createPostListForUser(@RequestBody PostWrapper postWrapper)
			throws JsonParseException, JsonMappingException, IOException {
		if (postWrapper == null)
			throw new MissingRequiredInputException("request body is missing the post details");

		List<String> messsages = postWrapper.getInputMessageList();
		String firstName = postWrapper.getFirstName();
		String lastName = postWrapper.getLastName();
		String cityName = postWrapper.getCityName();

		if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(cityName) || CollectionUtils.isEmpty(messsages))
			throw new MissingRequiredInputException(
					"missing required input: user name, city or the post message empty");

		// insert User and get the Id back
		User newUser = UserRepository.save(new User(firstName, lastName));

		// insert post with the user id
		Timestamp currentTime = new Timestamp(new Date().getTime());
		for (String newPostMessage : messsages) {
			Post newPost = new Post(newPostMessage, currentTime, newUser);

			// make open weather api call for location details
			newPost.setLocationDetails(weatherResource.makeWeatherAPICall(cityName));
			postRepository.save(newPost);
		}
	}

	/**
	 * Method will get all the messages available in the DB
	 * 
	 * @return list of messages
	 */
	@GetMapping(path = "/getAllMessages")
	public List<Post> getAllMessages() {
		List<Post> posts = postRepository.findAll();
		return posts;
	}

	/**
	 * Method to comment for a post
	 * 
	 * @param comment
	 * @return the added string
	 */
	@PostMapping(path = "/postComment")
	public String createComment(@RequestBody CommentWrapper comment) {
		if(comment == null) return "";
		
		Integer postId = comment.getPostId();
		String commentString = comment.getCommentString();
		
		if(postId ==null || isEmpty(commentString))
			throw new MissingRequiredInputException("required input postId or commentString is missing");
		
		commentRepository.save(new Comment(commentString, new Post(postId)));
		return commentString;

	}

}
