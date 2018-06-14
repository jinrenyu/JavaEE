package com.tz.online.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_book")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3786999447890971049L;
	
	private Long userId; //用户id
	private String userName; 
	private String passWord;
	private String email;
	private String phone;
	private String company;
	private String address;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String passWord, String email, String phone, String company, String address) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}

	public User(Long userId, String userName, String passWord, String email, String phone, String company,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}







	@Id
	@GeneratedValue
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", phone=" + phone + ", company=" + company + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
	
}