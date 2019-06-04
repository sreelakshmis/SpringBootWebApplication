package com.example.demo.wrapper;

import java.util.List;

public class PostWrapper {

	private List<String> inputMessageList;
	private String firstName;
	private String LastName;
	private String cityName;

	public PostWrapper() {

	}

	public PostWrapper(List<String> inputMessageList, String firstName, String lastName) {
		super();
		this.inputMessageList = inputMessageList;
		this.firstName = firstName;
		LastName = lastName;
	}

	public void setInputMessageList(List<String> inputMessageList) {
		this.inputMessageList = inputMessageList;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public List<String> getInputMessageList() {
		return inputMessageList;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return LastName;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


}
