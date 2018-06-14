package com.tz.day15.homework;

import org.junit.Test;

import com.tz.day15.Homework;

public class HomeworkTest
{
	@Test
	public void test()
	{
		Homework h=new Homework();
		if(h.copy("e:\\a.gif", "e:\\test"))
		{
			System.out.println("文件复制完毕");
		}
		if(h.copy1("e:\\英雄时刻", "e:\\test1"))
		{
			System.out.println("文件夹复制完毕完毕");
		}
	}
}
