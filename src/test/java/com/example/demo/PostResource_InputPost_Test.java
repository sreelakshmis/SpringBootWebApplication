package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PostResource;
import com.example.demo.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostResource_InputPost_Test {

	@Autowired
	PostResource postResource;

	Post post;

	@Test
	public void validateInputPost() {
		post = new Post(null, "test message");

		// test valid input
		assertEquals("test message", postResource.inputPost(post));

		// test case sensitivity
		assertNotEquals("TEST MESSAGE", postResource.inputPost(post));

		// test null input
		assertNotNull(postResource.inputPost(null));
		assertEquals("", postResource.inputPost(null));

	}

}
