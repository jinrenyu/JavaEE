package com.tz.day06;

public class Person 
{

	private String name;//null
	
	private int age;//0
	
	private String gender;//null
	
	private double height;//0.0
	
	private double weight;
	
	//构造方法没有返回类型连void都不写
	//一个类的构造方法名是确定的,必须与类名保持一致
	public Person()
	{
		System.out.println("空参构造被其他构造调用了");
//		this(20);
	}
	
	public Person(int age)
	{
		this();//this方法指代当前类型已存在的构造
		this.setAge(age);
	}
	
	//一个类中如果没有指明构造方法,系统会提供一个无参构造
	//如果类中提供了有参构造,那么系统就不在提供无参构造
	public Person(String name)
	{
		this.name = name;
		this.height = 0.0;
	}

	public Person(String name, int age, String gender, double height, double weight)
	{
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.setAge(age);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		if(age < 0 || age > 250)
		{
			System.out.println("输入de年龄不合常理");
			return;
		}
		this.age = age;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	
//	@Override
//	public String toString()
//	{
//		return name + "," + age + "," + gender;
//	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height + ", weight="
				+ weight + "]";
	}

	public void eatOrDrink(String food)
	{
		
	}
	
	public void sleep()
	{
		
	}
	
	public int add(int n1,int n2)
	{
		return n1 + n2;
	}
}
