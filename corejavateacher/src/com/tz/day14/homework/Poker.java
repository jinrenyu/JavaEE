package com.tz.day14.homework;

import java.util.ArrayList;
import java.util.List;

public class Poker
{
	private String brand = "默认品牌";
	//纸牌的母版
	private static final List<Card> MODEL;

	static
	{
		MODEL = new ArrayList<>();
		//
		for (Suit i : Suit.values())
		{
			for (Point j : Point.values())
			{
				Card c = new Card(i, j);
				MODEL.add(c);
			}
		}
	}

	public Poker()
	{
		super();
	}

	public Poker(String brand)
	{
		super();
		this.brand = brand;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	//产生新的扑克牌
	public static List<Card> newPoker()
	{
		return new ArrayList<>(MODEL);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		//
		int count = 0;
		for(Card c : MODEL) {
			count++;
			if(count % 13 == 0) {
				builder.append("\n");
			}
			builder.append(c);
		}
		return builder.toString();
	}
	
	

}
