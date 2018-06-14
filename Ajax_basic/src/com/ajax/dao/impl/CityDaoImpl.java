package com.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ajax.dao.CityDao;
import com.ajax.template.JdbcTemplate;
import com.ajax.template.interf.SqlQuerier;
import com.ajax.util.JdbcUtil;
import com.ajax.vo.City;

public class CityDaoImpl implements CityDao {

	@Override
	public List<City> getCitiesByPcode(String code) {
		JdbcTemplate<List<City>> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<List<City>>() {
			
			@Override
			public List<City> execute(Connection con) throws SQLException {
				String sql = "select * from city where provinceId = ?";
				PreparedStatement pst = null;
				ResultSet rs = null;
				List<City> cities = null;
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, code);
					rs = pst.executeQuery();
					cities = new ArrayList<>();
					while (rs.next()) {
						// ��װ���һ��ʡ�ݶ���
						City city = new City();
						city.setId(rs.getInt("id"));
						city.setCode(rs.getString("code"));
						city.setName(rs.getString("name"));
						
						// �ѷ�װ�õ�ʡ�ݶ�����ӽ����Ҫ���ص��б������
						cities.add(city);
					}
				} finally {
					JdbcUtil.close(rs, pst, null);
				}
				return cities;
			}
		});
	}

}
