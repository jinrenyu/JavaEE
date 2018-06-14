package com.tz.online.service.test;
import java.util.List;

import org.testng.annotations.Test;


import com.tz.online.entity.Book;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

public class BookServiceImplTest {

	private IBookService bookService = (IBookService) BeanFactory.createBeans("bookService");
	@Test
	public void testFindByPage() {
		PageBean<Book> page = bookService.findByPage(null, "特价图书", 2, 2);
		System.out.println("当前页:"+page.getPageNow());
		System.out.println("每页显示:"+page.getPageSize());
		System.out.println("总的条数:"+page.getRowCount());
		System.out.println("总的页数:"+page.getPageCount());
		System.out.println("\t图书信息:");
		
		List<Book> list = page.getList();
		if(null!=list && list.size()>0){
			for (Book book : list) {
				System.out.println("\t"+book);
			}
		}else{
			System.out.println("\t没有图书信息");
		}
	}

	@Test
	public void testFindById() {
		System.out.println(bookService.findById(3l));
	}

	@Test
	public void testFindByCategory(){
		List<Book> list = bookService.fingByCategory("特价图书");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
}
