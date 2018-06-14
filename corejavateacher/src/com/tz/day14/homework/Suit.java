package com.tz.day14.homework;

public enum Suit
{
	SPADE("黑桃"), HEART("红桃"), 
	DIAMOND("方块"), CLUB("梅花");

	private final String value;

	private Suit(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return this.value;
	}

}
