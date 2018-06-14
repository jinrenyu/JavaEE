package com.tz.online.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**图书实体类**/
@Entity
@Table(name="bsbook")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6613866198920316095L;
	
	private Long bookId; //图书id
	private String isbn; //图书编号
	private String name;
	private String author;
	private String publisher;
	private Date publish_date;
	private double oldPrice; //原价格
	private double newPrice;//现价
	private String author_loc; //作者地区;
	private Suit suit; //是否是套装
	private Category category; //图书类别
	private String info;
	private String imgUrl; //图片
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String name, String author, String publisher, Date publish_date, double oldPrice,
			double newPrice, String author_loc, Suit suit, Category category, String info, String imgUrl) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.author_loc = author_loc;
		this.suit = suit;
		this.category = category;
		this.info = info;
		this.imgUrl = imgUrl;
	}

	public Book(Long bookId, String isbn, String name, String author, String publisher, Date publish_date,
			double oldPrice, double newPrice, String author_loc, Suit suit, Category category, String info,
			String imgUrl) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.author_loc = author_loc;
		this.suit = suit;
		this.category = category;
		this.info = info;
		this.imgUrl = imgUrl;
	}

	@Id
	@GeneratedValue(generator="gen_book_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="gen_book_id", sequenceName="bs_bookId",initialValue=10, allocationSize=20)
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	@Column
	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	@Column
	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	@Column
	public String getAuthor_loc() {
		return author_loc;
	}

	@Column
	public void setAuthor_loc(String author_loc) {
		this.author_loc = author_loc;
	}

	@Column
	@Enumerated(EnumType.STRING)
	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Column
	@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", name=" + name + ", author=" + author + ", publisher="
				+ publisher + ", publish_date=" + publish_date + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice
				+ ", author_loc=" + author_loc + ", suit=" + suit + ", category=" + category + ", info=" + info
				+ ", imgUrl=" + imgUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((author_loc == null) ? 0 : author_loc.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(newPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(oldPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publish_date == null) ? 0 : publish_date.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (author_loc == null) {
			if (other.author_loc != null)
				return false;
		} else if (!author_loc.equals(other.author_loc))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (category != other.category)
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(newPrice) != Double.doubleToLongBits(other.newPrice))
			return false;
		if (Double.doubleToLongBits(oldPrice) != Double.doubleToLongBits(other.oldPrice))
			return false;
		if (publish_date == null) {
			if (other.publish_date != null)
				return false;
		} else if (!publish_date.equals(other.publish_date))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	
	
}
