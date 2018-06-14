package com.tz.cels.entity;

import java.util.Arrays;

/*
 * @description 词汇类
 */
public class Vocabulary extends BaseTerm 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6880251281643814692L;

	private String acronym;//词汇缩写

	public Vocabulary(String en, String[] cn, String acronym)
	{
		super(en, cn);
		this.acronym = acronym;
	}

	public Vocabulary()
	{
		super();
	}

	public Vocabulary(long id, String en, String[] cn, String acronym)
	{
		super(id, en, cn);
		this.acronym = acronym;
	}
	

	public String getAcronym()
	{
		return acronym;
	}

	public void setAcronym(String acronym)
	{
		this.acronym = acronym;
	}
	

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Vocabulary [en=").append(getEn()).append(", cn=")
		.append(Arrays.toString(getCn())).append(", acronym=").append(getAcronym()).append("]");
		return builder.toString();
	}

}
