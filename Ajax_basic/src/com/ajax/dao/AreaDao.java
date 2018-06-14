package com.ajax.dao;

import java.util.List;

import com.ajax.vo.Area;

public interface AreaDao {

	List<Area> getAreasByPcode(String code);
}
