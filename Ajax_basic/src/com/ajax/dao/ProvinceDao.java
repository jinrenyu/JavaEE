package com.ajax.dao;

import java.util.List;

import com.ajax.vo.Province;

public interface ProvinceDao {

	List<Province> getAllProvinces();
	
	Integer getTotal();
	
	List<Province> getProvinceByPage(Integer currentPage, Integer pageCount);
}
