package com.el.entity;

public class Address {

	private String province;
	
	private String city;

	public Address() {
		super();
	}

	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}
	
}
