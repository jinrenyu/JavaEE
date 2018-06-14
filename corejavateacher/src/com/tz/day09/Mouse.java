package com.tz.day09;

import java.io.Serializable;

//实现类可以实现多个接口,接口之间用(,)隔开
public class Mouse implements Usb,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8279777899456981137L;

	@Override
	public void connect()
	{
		System.out.println("鼠标实现了usb接口");
	}

}
