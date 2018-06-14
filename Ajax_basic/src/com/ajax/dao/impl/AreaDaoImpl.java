package com.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ajax.dao.AreaDao;
import com.ajax.template.JdbcTemplate;
import com.ajax.template.interf.SqlQuerier;
import com.ajax.util.JdbcUtil;
import com.ajax.vo.Area;

public class AreaDaoImpl implements AreaDao {

	@Override
	public List<Area> getAreasByPcode(String code) {
		JdbcTemplate<List<Area>> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<List<Area>>() {
			
			@Override
			public List<Area> execute(Connection con) throws SQLException {
				String sql = "select * from area where cityId = ?";
				PreparedStatement pst = null;
				ResultSet rs = null;
				List<Area> areas = null;
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, code);
					rs = pst.executeQuery();
					areas = new ArrayList<>();
					while (rs.next()) {
						Area area = new Area();
						area.setId(rs.getInt("id"));
						area.setCode(rs.getString("code"));
						area.setName(rs.getString("name"));
						
						areas.add(area);
					}
				} finally {
					JdbcUtil.close(rs, pst, null);
				}
				return areas;
			}
		});
	}

}
