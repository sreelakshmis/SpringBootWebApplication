package com.example.demo.controller;

import static com.example.demo.utils.Constants.API_KEY;
import static com.example.demo.utils.Constants.BASE_URL;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.exception.CityNotFoundException;
import com.example.demo.model.Weather;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherResource {
	
	/**
	 * This methods makes a all to the Weather API which takes an input string : city 
	 * valid list of cities found in http://bulk.openweathermap.org/sample/city.list.json.gz
	 * @param city
	 * @return String in the format : (city:Toronto,lat:43.65,long:-79.39,temp:281.85)
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String makeWeatherAPICall(String city) throws JsonParseException, JsonMappingException, IOException {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(BASE_URL).path("")
				.query("q={keyword}&appid={appid}").buildAndExpand(city, API_KEY);

		String uri = uriComponents.toUriString();
		RestTemplate restTemplate = new RestTemplate();

		try {
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
		ObjectMapper mapper = new ObjectMapper();
		Weather weather = mapper.readValue(response.getBody(), Weather.class);

		StringBuilder weatherData = new StringBuilder();
		weatherData.append("(city:");
		weatherData.append(city);
		weatherData.append(",lat:");
		weatherData.append(weather.getLat());
		weatherData.append(",long:");
		weatherData.append(weather.getLon());
		weatherData.append(",temp:");
		weatherData.append(weather.getTemp());
		weatherData.append(")");

		return weatherData.toString();
		} catch (Exception e) {
			throw new CityNotFoundException("invalid city:"+ city);
		}
	}

}
