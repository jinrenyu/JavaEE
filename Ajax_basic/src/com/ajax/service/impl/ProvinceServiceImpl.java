package com.ajax.service.impl;

import java.util.List;

import com.ajax.dao.ProvinceDao;
import com.ajax.dao.impl.ProvinceDaoImpl;
import com.ajax.service.ProvinceService;
import com.ajax.vo.Province;
import com.alibaba.fastjson.JSON;

public class ProvinceServiceImpl implements ProvinceService {
	
	private ProvinceDao provinceDao = new ProvinceDaoImpl();

	@Override
	public String getJSONProvincesStr() {
		return JSON.toJSONString(provinceDao.getAllProvinces());
	}

	@Override
	public List<Province> getAllProvinces() {
		return provinceDao.getAllProvinces();
	}

	@Override
	public Integer getTotalPage(Integer pageCount) {
		Integer total = provinceDao.getTotal();
		return (total - 1) / pageCount + 1;
	}

	@Override
	public List<Province> getProvincesByPage(Integer currentPage, Integer pageCount) {
		return provinceDao.getProvinceByPage(currentPage, pageCount);
	}

	@Override
	public Integer getTotal() {
		return provinceDao.getTotal();
	}

}
