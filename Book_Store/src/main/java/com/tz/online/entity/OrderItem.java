package com.tz.online.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="oitem_book")
public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1045639670180395615L;

	private Long itemId; //商品明细id标识
	private String book_isbn;
	Book book; 
	private String book_author;
	private int count; //购买数量
	private double allPrice; //此明细的总价格
	private Order order; //此明细所有的订单
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	

	public OrderItem(String book_isbn, Book book, String book_author, int count, double allPrice, Order order) {
		super();
		this.book_isbn = book_isbn;
		this.book = book;
		this.book_author = book_author;
		this.count = count;
		this.allPrice = allPrice;
		this.order = order;
	}



	public OrderItem(Long itemId, String book_isbn, Book book, String book_author, int count, double allPrice,
			Order order) {
		super();
		this.itemId = itemId;
		this.book_isbn = book_isbn;
		this.book = book;
		this.book_author = book_author;
		this.count = count;
		this.allPrice = allPrice;
		this.order = order;
	}



	@Id
	@GeneratedValue
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column
	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	
	@OneToOne
	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	@Column
	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	@Column
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Column
	public double getAllPrice() {
		allPrice=this.count*this.book.getNewPrice();
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice =this.count*this.book.getNewPrice();
	}

	@ManyToOne
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", book_isbn=" + book_isbn + ", book=" + book + ", book_author="
				+ book_author + ", count=" + count + ", allPrice=" + allPrice + ", order=" + order + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(allPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((book_author == null) ? 0 : book_author.hashCode());
		result = prime * result + ((book_isbn == null) ? 0 : book_isbn.hashCode());
		result = prime * result + count;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (Double.doubleToLongBits(allPrice) != Double.doubleToLongBits(other.allPrice))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (book_author == null) {
			if (other.book_author != null)
				return false;
		} else if (!book_author.equals(other.book_author))
			return false;
		if (book_isbn == null) {
			if (other.book_isbn != null)
				return false;
		} else if (!book_isbn.equals(other.book_isbn))
			return false;
		if (count != other.count)
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	
	
}
