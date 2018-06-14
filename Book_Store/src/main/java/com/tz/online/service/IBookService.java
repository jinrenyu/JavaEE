package com.tz.online.service;

import java.util.List;

import com.tz.online.entity.Book;
import com.tz.online.entity.PageBean;
public interface IBookService {

	
	public PageBean<Book> findByPage(String bookName, String category, long pageNow, long pageSize);
	
	public Book findById(Long id);
	
	public List<Book> fingByCategory(String category);
}
