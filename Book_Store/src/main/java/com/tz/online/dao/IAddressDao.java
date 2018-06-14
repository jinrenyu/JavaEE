package com.tz.online.dao;

import java.util.List;

import com.tz.online.entity.Address;

public interface IAddressDao {

	//保存地址
	public void save(Address address);
	//通过指定用户的id的所有地址
	public List<Address> findByUserId(Long userId);
	//删除某个地址
	public void delete(Address a);
	//通过id查询地址
	public Address findById(Long id);
	//更新地址
	public void update(Address a);
}
