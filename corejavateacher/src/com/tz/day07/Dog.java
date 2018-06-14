package com.tz.day07;

import java.util.Date;

import com.tz.util.DateUtil;

public class Dog extends Animal
{
	private String color;
	
	private Date birth;
	
	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public Dog()
	{
		//super方法指代父类已存在的构造方法
		super();
	}

	public Dog(String color, Date birth)
	{
		super();
		this.color = color;
		this.birth = birth;
	}

	public Dog(String name, String gender, double weight, double time, String color, Date birth)
	{
		super(name, gender, weight, time);
		this.color = color;
		this.birth = birth;
	}

	public Dog(String name, String gender, double weight, double time)
	{
		super(name, gender, weight, time);
	}

	@Override
	public String toString()
	{
		return super.toString() + "Dog [color=" + color + ", birth=" + DateUtil.formatDate(birth, "yyyy-MM-dd") + "]";
	}

	@Override
	public void move() throws ArrayIndexOutOfBoundsException
	{
		System.out.println(this.getName() + "用四条腿移动");
	}
}
