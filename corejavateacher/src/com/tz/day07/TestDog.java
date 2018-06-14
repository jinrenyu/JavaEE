package com.tz.day07;

import org.junit.Test;

import com.tz.util.DateUtil;

public class TestDog
{
	@Test
	public void test()
	{
		//创建一个Dog对象
		Dog dog = new Dog("black",DateUtil.setDate(2017, 3, 7));
		dog.setName("来福");
		dog.eat("狗肉");
		dog.move();
		System.out.println(dog);
		
		Animal dog1 = new Dog();
		dog1.move();
		
		Animal cat = new Cat();
		cat.move();
		
		Dog dog2 = (Dog)dog1;
		
		if(cat instanceof Dog)
		{
			Dog dog3 = (Dog)cat;
			dog3.move();
		}
	}
}
