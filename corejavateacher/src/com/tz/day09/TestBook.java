package com.tz.day09;

import org.junit.Test;

import com.tz.util.DateUtil;

public class TestBook
{
	@Test
	public void test()
	{
		//创建Book对象
		Book book1 = new Book("西游记","吴承恩",
				DateUtil.setDate(2000, 3, 5),50.0,700);
		Book book6 = new Book("西游记","吴承恩",
				DateUtil.setDate(2000, 3, 5),50.0,700);
		Book book2 = new Book("金瓶梅","兰陵笑笑生",
				DateUtil.setDate(2008, 10, 21),30.0,400);
		Book book3 = new Book("平凡的世界","路遥",
				DateUtil.setDate(2009, 4, 8),40.0,500);
		Book book4 = new Book("呐喊","鲁迅",
				DateUtil.setDate(2002, 3, 5),50.0,200);
		Book book5 = new Book("彷徨","鲁迅",
				DateUtil.setDate(1995, 5, 5),50.0,150);
	
		//创建IBook对象
		IBook bookService = new BookService();
		bookService.addBook(book1);
		bookService.addBook(book2);
		bookService.addBook(book3);
		bookService.addBook(book4);
		bookService.addBook(book5);
		bookService.addBook(book6);
		
//		Book[] dltBooks = bookService.deleteByName("西游记");
//		for (int i = 0; i < dltBooks.length; i++)
//		{
//			System.out.println(dltBooks[i]);
//		}
//		System.out.println("------------------");
		
		bookService.updateByDate(DateUtil.setDate(2000, 1, 1), 
				DateUtil.setDate(2005, 1, 1), 100);
		
		bookService.show();
		System.out.println("-----------------");
		Book[] books = bookService.selectByAuthor("鲁迅");
		for(Book b : books)
		{
			System.out.println(b);
		}
	}
}
