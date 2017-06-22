package com.thallam.tinyurl.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thallam.tinyurl.dto.UrlEntries;

@Component
public class UrlEntriesDaoUtil{
	
	@Autowired
	URLEntriesRepository repository;
	
	public UrlEntries getById(int id){
		
		return repository.findOne(id);
	}
	
	public UrlEntries save(UrlEntries entity) {
		
		UrlEntries newentry = new  UrlEntries();
		newentry.setUrlValue(entity.getUrlValue());
		newentry.setCreatedTime(new Date());
		
		newentry = repository.save(newentry);
		
		return newentry;
	}
}
