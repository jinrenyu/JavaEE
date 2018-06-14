package com.tz.online.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_book")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8295017107993726302L;

	private Long orderId; //订单id标识
	private String orderNum; //订单标号
	private Date createDate; //下单日期
	private Set<OrderItem> items; //订单中的商品明细
	private User user; //订单所属用户
	private Address address; //订单的发货地址
	private OrderStatus orderStatus; //订单状态
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String orderNum, Date createDate, Set<OrderItem> items, User user, Address address,
			OrderStatus orderStatus) {
		super();
		this.orderNum = orderNum;
		this.createDate = createDate;
		this.items = items;
		this.user = user;
		this.address = address;
		this.orderStatus = orderStatus;
	}

	public Order(Long orderId, String orderNum, Date createDate, Set<OrderItem> items, User user, Address address,
			OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.createDate = createDate;
		this.items = items;
		this.user = user;
		this.address = address;
		this.orderStatus = orderStatus;
	}

	@Id
	@GeneratedValue
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(mappedBy="order")
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column
	@Enumerated(EnumType.STRING)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNum=" + orderNum + ", createDate=" + createDate + ", items="
				+ items + ", user=" + user + ", address=" + address + ", orderStatus=" + orderStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
