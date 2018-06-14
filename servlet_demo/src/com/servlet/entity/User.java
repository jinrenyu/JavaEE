package com.servlet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ʵ����һ�㶼Ҫ����һ����׼��JavaBean(4������Ҫ��):
 * 1. ���еĳ�Ա������ʹ��private(˽��)��������
 * 2. ˽�еĳ�Ա�����ṩpublic(������)���ε�set/get����, ����
 * ������������(�����Ա����abc): setAba()/getAbc()
 * 3. �����Ա������boolean����: ����ʹ��isAbc()����getAbc()(���Ƽ�)
 * 4. �����ṩһ���޲εĹ��캯��
 * ����������ʾ
 * @author Chris
 *
 * 2017��5��10������9:25:37
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {

	private static final long serialVersionUID = -81127870535360488L;

	/*
	 * �û�����ID
	 */
	private Integer id;
	/*
	 * �û���
	 */
	private String username;
	/*
	 * �û�����
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
