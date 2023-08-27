package com.stackroute.news.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserNews {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="userId")
	int userId;
	
	List<News> newsList;

	public UserNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNews(int userId, List<News> newsList) {
		super();
		this.userId = userId;
		this.newsList = newsList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
}
