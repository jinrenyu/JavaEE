package com.ajax.service.impl;

import com.ajax.dao.AreaDao;
import com.ajax.dao.impl.AreaDaoImpl;
import com.ajax.service.AreaService;
import com.alibaba.fastjson.JSON;

public class AreaServiceImpl implements AreaService {

	private AreaDao areaDao = new AreaDaoImpl();
	
	@Override
	public String getJSONAreaStr(String code) {
		return JSON.toJSONString(areaDao.getAreasByPcode(code));
	}

}
