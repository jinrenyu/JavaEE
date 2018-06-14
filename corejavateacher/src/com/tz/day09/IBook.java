package com.tz.day09;

import java.util.Date;

public interface IBook
{
	/*
	 * 添加一本图书
	 */
	void addBook(Book book);
	
	/*
	 * 根据书名删除图书
	 */
	Book[] deleteByName(String name);
	
	/*
	 * 修改指定时间段内的图书的价格
	 */
	void updateByDate(Date start,Date end,double money);
	
	/*
	 * 查找指定作者的图书
	 */
	Book[] selectByAuthor(String author);
	
	/*
	 * 展示所有的图书
	 */
	void show();
}
