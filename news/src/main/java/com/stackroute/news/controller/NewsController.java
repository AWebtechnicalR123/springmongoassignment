package com.stackroute.news.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.news.model.News;
import com.stackroute.news.repository.UserNewsRepository;
import com.stackroute.news.service.NewsService;
import com.stackroute.news.util.exception.NewsAlreadyExistsException;
import com.stackroute.news.util.exception.NewsNotFoundException;

@RestController
@RequestMapping("/api/v1/news/")
public class NewsController {
	@Autowired
	NewsService nsi;
	
	@Autowired
	UserNewsRepository unr;
	
	@GetMapping("get")
	Iterable<News> getall(){
		Iterable<News> ins=null;
		try {
			 ins = nsi.get();
		} catch(NewsNotFoundException e) {
			e.printStackTrace();
		}
		return ins;
			
	}
	
	@PostMapping("post")
	News addNews(@RequestBody News news) {
		News ne=null;
		try {
			ne = nsi.save(news);
		} catch (NewsAlreadyExistsException e) {
			e.printStackTrace();
		}
		return ne;
	}
	
	@DeleteMapping("/{id}")
	String delete(@PathVariable int id) {
		try {
			nsi.deleteAll(id);
			return "News deleted Succesfully";
		} catch(NewsNotFoundException e) {
			e.printStackTrace();
			return "News Not Found";
		}
		
	}
	
	@PutMapping("/update/{id}")
	News updateNews(@RequestBody News ns, @PathVariable int id) {
		News ne = null;
		try {	
			ne = nsi.update(id, ns);
			
		} catch(NewsNotFoundException e) {
			e.printStackTrace();
		}
		return ne;
	}
	
	
}
