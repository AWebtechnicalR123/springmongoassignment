package com.stackroute.news.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.news.model.News;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.repository.NewsRepository;
import com.stackroute.news.util.exception.NewsAlreadyExistsException;
import com.stackroute.news.util.exception.NewsNotFoundException;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsRepository nr;
	
	@Override
	public Iterable<News> get() throws NewsNotFoundException{
		if(nr.findAll().isEmpty()) {		
			throw new NewsNotFoundException();	
		}
		return nr.findAll();
	}
	
	@Override
	public News save(News news) throws NewsAlreadyExistsException {
		if(nr.existsById(news.getNewsId())) {
			if(nr.findById(news.getNewsId()).get().equals(news)) {			
				throw new NewsAlreadyExistsException();
			} 
		}
		news.setPublishedAt();
		return nr.save(news);
	
	}

	@Override
	public void deleteAll(int id) throws NewsNotFoundException{
		if(!nr.existsById(id)) {		
			throw new NewsNotFoundException();	
		}
		nr.deleteById(id);
		
	}

	@Override
	public News update(int id, News news) throws NewsNotFoundException{
		if(!nr.existsById(id)) {		
			throw new NewsNotFoundException();	
		}	
		
		News ns = nr.findById(id).get();
		
		ns.setAuthor(news.getAuthor());
		ns.setContent(news.getContent());
		ns.setDescription(news.getDescription());
		ns.setPublishedAt();
		ns.setTitle(news.getTitle());
		ns.setUrl(news.getUrl());
		ns.setUrlToImage(news.getUrlToImage());
		return nr.save(ns);
	}

	
}
