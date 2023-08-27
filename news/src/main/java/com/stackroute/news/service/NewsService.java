package com.stackroute.news.service;

import com.stackroute.news.model.News;
import com.stackroute.news.util.exception.NewsAlreadyExistsException;
import com.stackroute.news.util.exception.NewsNotFoundException;

public interface NewsService {
	News save(News news) throws NewsAlreadyExistsException;
	Iterable<News> get() throws NewsNotFoundException;
	void deleteAll(int id) throws NewsNotFoundException;
	News update(int id, News news) throws NewsNotFoundException;
//	void showList(int id);
}
