package com.thallam.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thallam.tinyurl.dao.UrlEntriesDaoUtil;
import com.thallam.tinyurl.dao.UrlShortnerMapDaoUtil;
import com.thallam.tinyurl.dto.UrlEntries;
import com.thallam.tinyurl.dto.UrlShortnerMap;
import com.thallam.tinyurl.util.EncodeUtil;

@Service
public class UrlEntriesServiceImpl {
	
	@Autowired
	private UrlEntriesDaoUtil urlDaoUtil;
	
	@Autowired
	private EncodeUtil encodeUtil;
	
	@Autowired
	private UrlShortnerMapDaoUtil urlShortnerMapDaoUtil;

	public UrlEntries getUrlEntryById(int id) {

		return urlDaoUtil.getById(id);
	}

	public UrlEntries insertIntoUrlEntries(UrlEntries entity) {

		return urlDaoUtil.save(entity);
	}
	
	public UrlShortnerMap insertIntoUrlShortnerMap(UrlShortnerMap urlShortnerEntity) {
		return urlShortnerMapDaoUtil.save(urlShortnerEntity);
	}
	
	public UrlShortnerMap insertUrlReturnShortnerValue(UrlEntries entity){
		
		System.out.println("Inside the insertUrlReturnShortnerValue");
		UrlEntries urlentry = urlDaoUtil.save(entity);
		System.out.println("urlentry is saved and the id is "+urlentry!=null?urlentry.getUrlId():-1);

		String encoded = encodeUtil.encode(urlentry.getUrlId());
		
		UrlShortnerMap response = new UrlShortnerMap();
		response.setUrlId(urlentry.getUrlId());
		response.setUrlShortValue(encoded);
		
		response = insertIntoUrlShortnerMap(response);
		
		System.out.println("Shortened the URL and returned value, shortned id is "+response.getUrlShortId());
		
		return response;
	}
	
	public UrlEntries getOriginalUrlValue(UrlShortnerMap urlShortnerEntity){
		
		int decoded = encodeUtil.decode(urlShortnerEntity.getUrlShortValue());
		System.out.println("decoded value is "+decoded);
		UrlEntries response = getUrlEntryById(decoded);
		return response;
	}
	
}
