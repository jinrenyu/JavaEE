package com.tz.cels.entity;

import java.util.List;
 
 
public class PageBean
{
	//必备属性
	private List<Word> wdatas;//数据
	private List<Vocabulary> vdatas;
	
	private int pageSize;//每页显示多少行
	
	
	//辅助属性
	private int first = 1;//第一页
	private int last;//最后一页
	
	private int previous;//上一页
	private int next;//下一页
	
	private int current;//当前页
	
	private int pages;//总页数
	private int total;//总记录数
	
	private String style;//分页样式

	public PageBean()
	{
		super();
	}

	public PageBean(List<Word> wdatas, List<Vocabulary> vdatas, int pageSize, int first, int last, int previous,
			int next, int current, int pages, int total, String style)
	{
		super();
		this.wdatas = wdatas;
		this.vdatas = vdatas;
		this.pageSize = pageSize;
		this.first = first;
		this.last = last;
		this.previous = previous;
		this.next = next;
		this.current = current;
		this.pages = pages;
		this.total = total;
		this.style = style;
	}

	public List<Word> getWdatas()
	{
		return wdatas;
	}

	public void setWdatas(List<Word> wdatas)
	{
		this.wdatas = wdatas;
	}

	public List<Vocabulary> getVdatas()
	{
		return vdatas;
	}

	public void setVdatas(List<Vocabulary> vdatas)
	{
		this.vdatas = vdatas;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getFirst()
	{
		return first;
	}

	public void setFirst(int first)
	{
		this.first = first;
	}

	public int getLast()
	{
		return last;
	}

	public void setLast(int last)
	{
		this.last = last;
	}

	public int getPrevious()
	{
		return previous;
	}

	public void setPrevious(int previous)
	{
		this.previous = previous;
	}

	public int getNext()
	{
		return next;
	}

	public void setNext(int next)
	{
		this.next = next;
	}

	public int getCurrent()
	{
		return current;
	}

	public void setCurrent(int current)
	{
		this.current = current;
	}

	public int getPages()
	{
		return pages;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public String getStyle()
	{
		return style;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [wdatas=").append(wdatas).append(", vdatas=").append(vdatas).append(", pageSize=")
				.append(pageSize).append(", first=").append(first).append(", last=").append(last).append(", previous=")
				.append(previous).append(", next=").append(next).append(", current=").append(current).append(", pages=")
				.append(pages).append(", total=").append(total).append(", style=").append(style).append("]");
		return builder.toString();
	}


	
	
	
	
	


}
