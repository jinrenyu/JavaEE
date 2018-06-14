package com.ajax.dao;

import java.util.List;

import com.ajax.vo.City;

public interface CityDao {

	List<City> getCitiesByPcode(String code);
}
