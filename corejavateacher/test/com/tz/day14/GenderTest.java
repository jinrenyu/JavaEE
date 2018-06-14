package com.tz.day14;

import org.junit.Assert;
import org.junit.Test;

public class GenderTest
{
	@Test
	public void testValues() {
		Gender[] gs = Gender.values();
		Assert.assertEquals(2, gs.length);
		System.out.println("断言成功");
		//
		for(Gender g : gs) {
			System.out.printf("常量名:%s, 序号：%d\n",
									g.name(),g.ordinal());
		}
	}
}
