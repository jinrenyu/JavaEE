package com.tz.online.dao.test;

import java.util.List;

import org.testng.annotations.Test;

import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.util.BeanFactory;

public class BookDaoImplTest {

	private IBookDao bookDaoImpl = (IBookDao) BeanFactory.createBeans("bookDao") ;     
	
	@Test
	public void testFindByCondition() {
		List<Book> book = bookDaoImpl.findByCondition(null, Category.推荐图书, 1, 10);
		for (Book b : book) {
			System.out.println(b);
		}
	}

	@Test
	public void testFindById() {
		
		System.out.println(bookDaoImpl.findById(2l));
	}

	@Test
	public void testGetRows() {
		System.out.println(bookDaoImpl.getRows(Category.特价图书, null));
	}

	@Test
	public void testFingByCategory(){
		List<Book> list = bookDaoImpl.fingByCategory(Category.推荐图书);
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
