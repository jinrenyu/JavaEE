package com.tz.cels;

import org.junit.Test;

import com.tz.cels.controller.impl.CelsController;

public class CelsControllerTest
{
	@Test
	public void test(){
		CelsController cc = new CelsController();
		cc.action();
	}
}
