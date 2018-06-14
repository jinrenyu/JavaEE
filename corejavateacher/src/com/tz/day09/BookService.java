package com.tz.day09;

import java.util.Arrays;
import java.util.Date;

public class BookService implements IBook
{
	Book[] books;
	
	int length;
	
	public BookService()
	{
		books = new Book[4];
	}

	@Override
	public void addBook(Book book)
	{
		//判断数组元素是否包含null值
		if(length == books.length)
		{
			//创建一个新数组,长度为length * 2
			Book[] newBooks = new Book[length + length];
			//将books数组中的元素添加到newBooks数组中
			for (int i = 0; i < length; i++)
			{
				newBooks[i] = books[i];
			}
			//将newBooks数组赋值给books
			books = newBooks;
		}
		//将Book对象添加到Book数组中
		books[length++] = book;
	}

	@Override
	public Book[] deleteByName(String name)
	{
		//创建一个Book数组
		Book[] newBooks = new Book[length];
		Book[] nBooks = new Book[books.length];
		int index = 0;
		int idx = 0;
		//遍历books数组
		for (int i = 0; i < length; i++)
		{
			//判断
			if(books[i].getName().equals(name))
			{
				newBooks[index++] = books[i];
			}else
			{
				nBooks[idx++] = books[i];
			}
		}
		//将nBooks数组赋值给books
		books = nBooks;
		length = idx;
		return Arrays.copyOf(newBooks, index);
	}

	@Override
	public void updateByDate(Date start, Date end, double money)
	{
		//遍历数组
		for(Book book : books)
		{
			//非空判断
			if(book != null)
			{
				Date date = book.getPublish_date();
				//判断book元素的date
				if(date.after(start) && date.before(end))
				{
					book.setPrice(money);
				}
			}
		}
	}

	@Override
	public Book[] selectByAuthor(String author)
	{
		//创建数组
		Book[] newBooks = new Book[length];
		int index = 0;
		//遍历数组
		for(Book book : books)
		{
			//非空判断
			if(book != null && book.getAuthor().equals(author))
			{
				newBooks[index++] = book;
			}
		}
		return Arrays.copyOf(newBooks, index);
	}

	@Override
	public void show()
	{
		for (int i = 0; i < length; i++)
		{
			System.out.println(books[i]);	
		}
	}

}
