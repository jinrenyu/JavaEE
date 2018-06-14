package com.tz.online.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_book")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 599088341063403917L;
	
	private Long addressId;//地址id
	private String area; //区域
	private String detailAddress; //详细地址
	private String emailCode; //邮编
	private String reciver; //收件人
	private String tel; //手机号
	private String isDefault; //是否默认收货地址,0:否    1:是
	private User user; //地址所属用户
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String area, String detailAddress, String emailCode, String reciver, String tel, String isDefault,
			User user) {
		super();
		this.area = area;
		this.detailAddress = detailAddress;
		this.emailCode = emailCode;
		this.reciver = reciver;
		this.tel = tel;
		this.isDefault = isDefault;
		this.user = user;
	}

	public Address(Long addressId, String area, String detailAddress, String emailCode, String reciver, String tel,
			String isDefault, User user) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.detailAddress = detailAddress;
		this.emailCode = emailCode;
		this.reciver = reciver;
		this.tel = tel;
		this.isDefault = isDefault;
		this.user = user;
	}

	@Id
	@GeneratedValue
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	@Column
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column
	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Column
	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	@Column
	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	@Column
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", detailAddress=" + detailAddress
				+ ", emailCode=" + emailCode + ", reciver=" + reciver + ", tel=" + tel + ", isDefault=" + isDefault
				+ ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((detailAddress == null) ? 0 : detailAddress.hashCode());
		result = prime * result + ((emailCode == null) ? 0 : emailCode.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((reciver == null) ? 0 : reciver.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (detailAddress == null) {
			if (other.detailAddress != null)
				return false;
		} else if (!detailAddress.equals(other.detailAddress))
			return false;
		if (emailCode == null) {
			if (other.emailCode != null)
				return false;
		} else if (!emailCode.equals(other.emailCode))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (reciver == null) {
			if (other.reciver != null)
				return false;
		} else if (!reciver.equals(other.reciver))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
