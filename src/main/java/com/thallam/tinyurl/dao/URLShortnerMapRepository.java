package com.thallam.tinyurl.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.thallam.tinyurl.dto.UrlEntries;
import com.thallam.tinyurl.dto.UrlShortnerMap;

public interface URLShortnerMapRepository extends CrudRepository<UrlShortnerMap, Serializable>{

}
