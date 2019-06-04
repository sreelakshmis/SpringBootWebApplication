package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PostResource;
import com.example.demo.data.CommentRepository;
import com.example.demo.exception.MissingRequiredInputException;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.wrapper.CommentWrapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostResource_CreateComment_Test {

	@Autowired
	PostResource postResource;

	@MockBean
	private CommentRepository commentRepository;

	@Test
	public void nullCommenttWrapper() {
		assertEquals("", postResource.createComment(null));
	}

	@Test(expected = MissingRequiredInputException.class)
	public void emptyCommentWrapper() {
		assertEquals("", postResource.createComment(new CommentWrapper()));
	}

	@Test
	public void validCommentCreation() {
		Comment newComment = new Comment("My comment", new Post(1));
		Mockito.when(commentRepository.save(newComment)).thenReturn(newComment);

		assertEquals("My comment", postResource.createComment(new CommentWrapper("My comment", 1, null)));
	}
}



