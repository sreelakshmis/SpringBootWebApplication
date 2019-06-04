package com.example.demo;

import static java.util.Arrays.asList;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PostResource;
import com.example.demo.exception.MissingRequiredInputException;
import com.example.demo.wrapper.PostWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostResource_CreatePostListForUser_Test {

	@Autowired
	PostResource postResource;

	@Test(expected = MissingRequiredInputException.class)
	public void nullPostWrapper() throws JsonParseException, JsonMappingException, IOException {

		postResource.createPostListForUser(null);
	}

	@Test(expected = MissingRequiredInputException.class)
	public void emptyPostWrapper() throws JsonParseException, JsonMappingException, IOException {

		postResource.createPostListForUser(new PostWrapper());
	}

	@Test(expected = MissingRequiredInputException.class)
	public void missingInputInPostWrapper() throws JsonParseException, JsonMappingException, IOException {
		PostWrapper postWrapper = new PostWrapper();
		postWrapper.setCityName("london");
		postWrapper.setFirstName("first");

		postResource.createPostListForUser(postWrapper);
	}

	@Test
	public void validCreation() throws JsonParseException, JsonMappingException, IOException {
		PostWrapper postWrapper = new PostWrapper();
		postWrapper.setCityName("london");
		postWrapper.setFirstName("first");
		postWrapper.setLastName("last");
		postWrapper.setInputMessageList(asList("post1"));

		postResource.createPostListForUser(postWrapper);
	}

}
