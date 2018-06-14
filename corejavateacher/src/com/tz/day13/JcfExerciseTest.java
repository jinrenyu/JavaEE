package com.tz.day13;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JcfExerciseTest
{
	private JcfExercise je;
	
	@Before
	public void init() {
		je = new JcfExercise();
	}
	
	@Test
	public void testGetList() {
		List<Integer> data = je.getList(100);
		//断言
		Assert.assertEquals(100, data.size());
		System.out.println("断言成功...");
	}
}
