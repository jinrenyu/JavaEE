package com.tz.day12;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Iterator;
import java.util.List;

import com.tz.day09.Book;

public class BookService implements IBook
{
	//创建一个集合
	List<Book> list = new ArrayList<>();

	@Override
	public void addBook(Book book)
	{
		list.add(book);
	}

	@Override
	public List<Book> deleteByName(String name)
	{
		List<Book> l = new ArrayList<>();
		/*//迭代器
		Iterator<Book> it = list.iterator();
		while(it.hasNext())
		{
			//获取下一个元素
			Book book = it.next();
			//判断作者的书名
			if(book != null && book.getName().equals(name))
			{
				//先将当前对象添加到新集合中
				l.add(book);
				//利用迭代器的删除方法删除当前对象
				it.remove();
			}
		}*/
		
		for(int i = 0;i < list.size();i++)
		{
			//获取下标对应的Book对象
			Book book = list.get(i);
			//判断作者的书名
			//判断作者的书名
			if(book != null && book.getName().equals(name))
			{
				//先将当前对象添加到新集合中
				l.add(book);
				//利用迭代器的删除方法删除当前对象
				list.remove(i);
				i--;
			}
		}
		return l;
	}

	@Override
	public void updateByDate(Date start, Date end, double money)
	{
		for(Book b : list)
		{
			//判断
			if(b != null && b.getPublish_date().after(start) && 
					b.getPublish_date().before(end))
			{
				b.setPrice(money);
			}
		}
	}

	@Override
	public List<Book> selectByAuthor(String author)
	{
		//创建一个集合
		List<Book> l = new ArrayList<>();
		//遍历集合
		for(Book book : list)
		{
			//判断
			if(book != null && book.getAuthor().equals(author))
			{
				//将当前的Book对象添加到集合中
				l.add(book);
			}
		}
		return l;
	}

	@Override
	public void show()
	{
		//遍历集合
		for(Book book : list)
		{
			System.out.println(book);
		}
	}

}
