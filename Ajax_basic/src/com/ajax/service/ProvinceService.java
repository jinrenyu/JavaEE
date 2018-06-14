package com.ajax.service;

import java.util.List;

import com.ajax.vo.Province;

public interface ProvinceService {

	String getJSONProvincesStr();
	
	List<Province> getAllProvinces();
	
	/**
	 * ��ȡ�ܵ�ҳ��
	 * @return ��ҳ��
	 */
	Integer getTotalPage(Integer pageCount);
	
	List<Province> getProvincesByPage(Integer currentPage, Integer pageCount);
	
	Integer getTotal();
}
