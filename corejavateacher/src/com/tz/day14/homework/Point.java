package com.tz.day14.homework;

public enum Point
{
	ACE("A"), TWO("2"), THREE("3"), 
	FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), 
	EIGHT("8"), NINE("9"), TEN("10"), 
	JACK("J"), QUEEN("Q"), KING("K");

	private final String value;

	private Point(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return this.value;
	}

}
