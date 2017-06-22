package com.thallam.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.thallam.tinyurl.dto.UrlEntries;
import com.thallam.tinyurl.dto.UrlShortnerMap;
import com.thallam.tinyurl.service.UrlEntriesServiceImpl;

@RestController
public class TinyUrlCtrl {
	
	
	@Autowired
	UrlEntriesServiceImpl service;
	
	@GetMapping("/{encoded}")
	public RedirectView getOriginalUrlValue(@PathVariable("encoded") String encoded){
		
		System.out.println("encoded value received is "+encoded);
		UrlEntries response = new UrlEntries();
		
		UrlShortnerMap urlShortnerEntity = new UrlShortnerMap();
		urlShortnerEntity.setUrlShortValue(encoded);
		
		response = service.getOriginalUrlValue(urlShortnerEntity);
		
		System.out.println("resposen received is "+response);
		
		return new RedirectView(response.getUrlValue());
	}
	
	@PostMapping("/addURLEntry")
	public @ResponseBody UrlShortnerMap addURLEntry(@RequestBody UrlEntries urlEntryInstance){
		try{
		return service.insertUrlReturnShortnerValue(urlEntryInstance);		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
