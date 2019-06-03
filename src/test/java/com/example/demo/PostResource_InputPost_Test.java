package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PostResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostResource_InputPost_Test {

	@Autowired
	PostResource postResource;

	@Test
	public void validateInputPost() {
		// test valid input
		assertEquals("test message", postResource.inputPost("test message"));

		// test case sensitivity
		assertNotEquals("TEST MESSAGE", postResource.inputPost("test message"));

		// test null input
		assertNull(postResource.inputPost(null));

	}

}
