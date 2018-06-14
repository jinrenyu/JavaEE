package com.jsp.entity;

public class User {
	private String username;
	private String pwd;
	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}
	public User() {
		super();
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=");
		builder.append(username);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append("]");
		return builder.toString();
	}
	
}
