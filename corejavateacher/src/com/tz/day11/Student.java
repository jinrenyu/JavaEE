package com.tz.day11;

public class Student
{
	private String name;
	
	private String gender;
	
	private int age;
	
	private double height;

	public Student()
	{
		super();
	}

	public Student(String name, String gender, int age, double height)
	{
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
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

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	@Override
	public String toString()
	{
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age + ", height=" + height + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (gender == null)
		{
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if(obj == null)//非空判断
//		{
//			return false;
//		}
//		if(!(obj instanceof Student))
//		{
//			return false;
//		}
//		Student s = (Student)obj;
//		//判断s的属性的值与当前对象属性的值是否相等
//		if(!s.name.endsWith(this.name))
//		{
//			return false;
//		}
//		return true;
//	}
}
