package com.example.demo;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.WeatherResource;
import com.example.demo.exception.CityNotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherResource_Test {
	WeatherResource resource = new WeatherResource();

	@Test
	public void validateCall() throws JsonParseException, JsonMappingException, IOException {
		String result = resource.makeWeatherAPICall("Toronto");
		assertNotNull(result);

	}

	@Test(expected = CityNotFoundException.class)
	public void inValidateCall() throws JsonParseException, JsonMappingException, IOException {
		resource.makeWeatherAPICall("newyork");

	}
}
