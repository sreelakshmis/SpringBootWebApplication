package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PostResource;
import com.example.demo.data.PostRepository;
import com.example.demo.model.Post;
import com.example.demo.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostResource_GetAllMessages_Test {

	@Autowired
	private PostResource postResource;

	@MockBean
	private PostRepository postRepository;

	public void dataSeup() {
		List<Post> response = new ArrayList<>();
		response.add(new Post("post1", new Timestamp(new Date().getTime()), new User("jolly", "mathew")));
		response.add(new Post("post2", new Timestamp(new Date().getTime()), new User("nick", "john")));
		Mockito.when(postRepository.findAll()).thenReturn(response);
	}

	@Test
	public void whenValid_AllPostsShouldBeFound() {
		dataSeup();
		List<Post> actualPost = postResource.getAllMessages();
		assertNotNull(actualPost);
		assertEquals(2, actualPost.size());
	}

	@Test
	public void whenNull_thenEmptyListShouldBeReturned() {
		assertEquals(0, postResource.getAllMessages().size());
	}
}
