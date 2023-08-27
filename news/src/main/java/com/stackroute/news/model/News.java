package com.stackroute.news.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//@Entity(name="News")
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="newsId")
	int newsId;
	
//	@Column(name="title")
	String title;
	
//	@Column(name="author")
	String author;
	
//	@Column(name="description")
	String description;
	
//	@Column(name="publishedAt")
//	String publishedAt;
	LocalDate publishedAt;
	
	
	
	String content;
	
	
	String url;
	
	
	String urlToImage;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int newsId, String title, String author, String description, LocalDate publishedAt, String content,
			String url, String urlToImage) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.publishedAt = LocalDate.now();
		this.content = content;
		this.url = url;
		this.urlToImage = urlToImage;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(newsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return newsId == other.newsId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public LocalDate getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt() {
		this.publishedAt = LocalDate.now();
	}

	
	
	
	
}
