package com.ajax.service;

import java.util.List;

import com.ajax.vo.Province;

public interface ProvinceService {

	String getJSONProvincesStr();
	
	List<Province> getAllProvinces();
	
	/**
	 * 获取总的页数
	 * @return 总页数
	 */
	Integer getTotalPage(Integer pageCount);
	
	List<Province> getProvincesByPage(Integer currentPage, Integer pageCount);
	
	Integer getTotal();
}
