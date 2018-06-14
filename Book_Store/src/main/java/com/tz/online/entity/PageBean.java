package com.tz.online.entity;

import java.util.List;

/**分页实体类**/
public class PageBean<T> {
	//当前页
	private long pageNow;
	
	//总的条数
	private long rowCount;
	
	//总的页数
	private long pageCount;
	
	//每页显示多少条
	private long pageSize;
	
	//分页的对象.
	private List<T> list;
	
	public PageBean() {
		// TODO Auto-generated constructor stub
	}

	public long getPageNow() {
		return pageNow;
	}

	public void setPageNow(long pageNow) {
		this.pageNow = pageNow;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [pageNow=" + pageNow + ", rowCount=" + rowCount + ", pageCount=" + pageCount + ", pageSize="
				+ pageSize + ", list=" + list + "]";
	}
}
