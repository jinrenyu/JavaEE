package com.tz.day09;

public abstract class Animal
{
	private String name;
	
	private String gender;

	public Animal()
	{
		super();
	}

	public Animal(String name, String gender)
	{
		super();
		this.name = name;
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	@Override
	public String toString()
	{
		return "Animal [name=" + name + ", gender=" + gender + "]";
	}
	
	//父类的抽象方法必须被子类重写,除非子类也是抽象类
	public abstract void move();
}
