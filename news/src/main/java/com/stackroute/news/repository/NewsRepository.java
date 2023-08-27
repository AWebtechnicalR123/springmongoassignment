package com.stackroute.news.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.news.model.News;

public interface NewsRepository extends MongoRepository<News, Integer>{

}
