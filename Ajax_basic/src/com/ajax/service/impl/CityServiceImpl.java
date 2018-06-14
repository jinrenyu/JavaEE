package com.ajax.service.impl;

import com.ajax.dao.CityDao;
import com.ajax.dao.impl.CityDaoImpl;
import com.ajax.service.CityService;
import com.alibaba.fastjson.JSON;

public class CityServiceImpl implements CityService {

	private CityDao cityDao = new CityDaoImpl();
	
	@Override
	public String getJSONCityStr(String code) {
		return JSON.toJSONString(cityDao.getCitiesByPcode(code));
	}

}
