package com.stackroute.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.news.model.UserNews;

public interface UserNewsRepository extends MongoRepository<UserNews, Integer>{

}
