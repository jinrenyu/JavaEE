package com.tz.online.service.impl;

import java.util.List;

import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

public class BookServiceImpl implements IBookService {

	private IBookDao bookDaoImpl = (IBookDao) BeanFactory.createBeans("bookDao");
	
	@Override
	public PageBean<Book> findByPage(String bookName, String category, long pageNow, long pageSize) {
		//创建pagebean对象
		PageBean<Book> page = new PageBean<Book>();
		//根据条件进行查找,跳去dao中的方法
		List<Book> list = bookDaoImpl.findByCondition(bookName, Category.valueOf(category), pageNow, pageSize);
		//封装list集合
		page.setList(list);
		//封装当前页
		page.setPageNow(pageNow);
		//封装每页显示多少条的
		page.setPageSize(pageSize);
		//封装总的条数
		long count = bookDaoImpl.getRows(Category.valueOf(category), bookName);
		page.setRowCount(count);
		//封装总的页数
		long pageCount = count/pageSize;
		//判断是否偶数页
		if(count%pageSize!=0){
			pageCount++;
		}
		page.setPageCount(pageCount);
		return page;
	}

	@Override
	public Book findById(Long id) {
		
		return bookDaoImpl.findById(id);
	}

	@Override
	public List<Book> fingByCategory(String category) {
		
		return bookDaoImpl.fingByCategory(Category.valueOf(category));
	}

	

}
