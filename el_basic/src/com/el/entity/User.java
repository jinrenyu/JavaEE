package com.el.entity;

public class User {
	private String username;
	private String pwd;
	private Address address;

	public User() {
		super();
	}
	
	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public User(String username, String pwd, Address address) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=");
		builder.append(username);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
