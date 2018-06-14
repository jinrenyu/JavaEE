package com.tz.online.dao;

import java.util.List;

import com.tz.online.entity.Book;
import com.tz.online.entity.Category;



public interface IBookDao {

	public List<Book> findByCondition(String bookName, Category category, long pageNow, long pageSize);
	
	public Book findById(Long id);
	
	public long getRows(Category category, String bookName);

	public List<Book> fingByCategory(Category category);
}
