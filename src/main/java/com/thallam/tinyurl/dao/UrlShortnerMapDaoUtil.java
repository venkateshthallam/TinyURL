package com.thallam.tinyurl.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thallam.tinyurl.dto.UrlShortnerMap;

@Component
public class UrlShortnerMapDaoUtil{

	@Autowired
	URLShortnerMapRepository repository;
	
	public UrlShortnerMap save(UrlShortnerMap entity) {
		return repository.save(entity);
	}

	
	public UrlShortnerMap findOne(Serializable id) {
		
		return null;
	}

	
	public boolean exists(Serializable id) {
		
		return false;
	}

	
	public long count() {
		
		return 0;
	}

}
