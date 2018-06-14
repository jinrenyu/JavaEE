package com.tz.cels.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TestRecord implements Comparable<TestRecord>,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3822225191557277631L;
	private Date date;// 测试时间
	private long time;// 时长
	private int count;// 总题数
	private int finishcount;// 完成题数
	private int rightcount;// 正确题数
	private int wrongcount;// 错误题数
	List<BaseTerm> list;// 测试记录

	public TestRecord()
	{
		super();
	}

	public TestRecord(Date date, long time, int count, int finishcount, int rightcount, int wrongcount,
			List<BaseTerm> list)
	{
		super();
		this.date = date;
		this.time = time;
		this.count = count;
		this.finishcount = finishcount;
		this.rightcount = rightcount;
		this.wrongcount = wrongcount;
		this.list = list;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public int getFinishcount()
	{
		return finishcount;
	}

	public void setFinishcount(int finishcount)
	{
		this.finishcount = finishcount;
	}

	public int getRightcount()
	{
		return rightcount;
	}

	public void setRightcount(int rightcount)
	{
		this.rightcount = rightcount;
	}

	public int getWrongcount()
	{
		return wrongcount;
	}

	public void setWrongcount(int wrongcount)
	{
		this.wrongcount = wrongcount;
	}

	public List<BaseTerm> getList()
	{
		return list;
	}

	public void setList(List<BaseTerm> list)
	{
		this.list = list;
	}
	

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("TestRecord [date=").append(date).append(", time=").append(time).append(", count=").append(count)
				.append(", finishcount=").append(finishcount).append(", rightcount=").append(rightcount)
				.append(", wrongcount=").append(wrongcount).append(", list=").append(list).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(TestRecord o)
	{
		return this.getDate().compareTo(o.getDate());
	}

}
