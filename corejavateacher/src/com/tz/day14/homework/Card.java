package com.tz.day14.homework;

public class Card
{
	private Suit suit;
	
	private Point point;

	public Card()
	{
		super();
	}

	public Card(Suit suit, Point point)
	{
		super();
		this.suit = suit;
		this.point = point;
	}

	public Suit getSuit()
	{
		return suit;
	}

	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}

	public Point getPoint()
	{
		return point;
	}

	public void setPoint(Point point)
	{
		this.point = point;
	}

	@Override
	public String toString()
	{
		return ""+this.suit+this.point;
	}
	
	
	

}
