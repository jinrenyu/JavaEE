package com.tz.cels.entity;

import java.io.Serializable;
import java.util.Arrays;

/*
 * @description 基本术语类，为扩展Word和Vocabulary而来
 */
public abstract class BaseTerm implements Serializable, Comparable<BaseTerm>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4735651675095997143L;

	private long id;// 编号
	private String en;// 英文单词
	private String[] cn;// 中文，可能会有多个解释
	// �ʻ����
	private String category = "计算机英语";

	public BaseTerm()
	{
		super();
	}

	public BaseTerm(String en, String[] cn)
	{
		super();
		this.en=en;
		this.cn=cn;
	}

	public BaseTerm(long id, String en, String[] cn)
	{
		super();
		this.id=id;
		this.en = en;
		this.cn=cn;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getEn()
	{
		return en;
	}

	public void setEn(String en)
	{
		this.en = en;
	}

	public String[] getCn()
	{
		return cn;
	}

	public void setCn(String[] cn)
	{
		this.cn = cn;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("BaseTerm [id=").append(id).append(", en=").append(en).append(", cn=")
				.append(Arrays.toString(cn)).append(", category=").append(category).append("]");
		return builder.toString();
	}
	public int compareTo(BaseTerm o)
	{
		return this.getEn().compareTo(o.getEn());
	}
	
	
	
	
}
