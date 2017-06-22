package com.thallam.tinyurl.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.thallam.tinyurl.dto.UrlEntries;

public interface URLEntriesRepository extends CrudRepository<UrlEntries, Serializable>{

}
