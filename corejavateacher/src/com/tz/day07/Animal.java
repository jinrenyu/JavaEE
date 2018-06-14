package com.tz.day07;

public class Animal
{
	
	private String name;
	
	private String gender;
	
	private double weight;
	
	private double time;
	
	public Animal()
	{
		super();
	}

	public Animal(String name, String gender, double weight, double time)
	{
		super();
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.time = time;
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

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}

	@Override
	public String toString()
	{
		return "Animal [name=" + name + ", gender=" + gender + ", weight=" + weight + ", time=" + time + "]";
	}

	public void eat(String food)
	{
		System.out.println(name + "在吃" + food);
	}
	
	public void move() throws RuntimeException
	{
		System.out.println(name + "在移动");
	}
	
}
