package com.tz.day09;

import java.util.Date;

public class Book
{
	private String name;
	private String author;
	private Date publish_date;
	private double price;
	private int pages;

	public Book()
	{
		super();
	}

	public Book(String name, String author, Date publish_date, double price, int pages)
	{
		super();
		this.name = name;
		this.author = author;
		this.publish_date = publish_date;
		this.price = price;
		this.pages = pages;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getPublish_date()
	{
		return publish_date;
	}

	public void setPublish_date(Date publish_date)
	{
		this.publish_date = publish_date;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getPages()
	{
		return pages;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	@Override
	public String toString()
	{
		return "Book [name=" + name + ", author=" + author + ", publish_date=" + publish_date + ", price=" + price
				+ ", pages=" + pages + "]";
	}

}
