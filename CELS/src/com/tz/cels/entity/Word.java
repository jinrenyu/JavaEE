package com.tz.cels.entity;

import java.util.Arrays;

/*
 * @description 单词类
 */
public class Word extends BaseTerm 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886005675711460389L;

	private char first;//首字母

	public Word()
	{
		super();
	}

	public Word(long id, String en, String[] cn)
	{
		super(id, en, cn);
	}

	public Word(String en, String[] cn)
	{
		super(en, cn);
	}
	

	public char getFirst()
	{
		return first;
	}

	public void setFirst(char first)
	{
		this.first = first;
	}

	

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Word [first=").append(first).append(", en=").append(getEn()).append(", cn=")
		.append(Arrays.toString(getCn())).append("]");
		return builder.toString();
	}


	

}
