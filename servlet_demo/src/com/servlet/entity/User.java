package com.servlet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类一般都要求是一个标准的JavaBean(4个基本要求):
 * 1. 所有的成员都必须使用private(私有)进行修饰
 * 2. 私有的成员必须提供public(公共的)修饰的set/get方法, 并且
 * 命名必须满足(比如成员名叫abc): setAba()/getAbc()
 * 3. 如果成员类型是boolean类型: 可以使用isAbc()代替getAbc()(不推荐)
 * 4. 必须提供一个无参的构造函数
 * 本类用来演示
 * @author Chris
 *
 * 2017年5月10日上午9:25:37
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {

	private static final long serialVersionUID = -81127870535360488L;

	/*
	 * 用户主键ID
	 */
	private Integer id;
	/*
	 * 用户名
	 */
	private String username;
	/*
	 * 用户密码
	 */
	private String password;
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
}
