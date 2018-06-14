package com.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ajax.dao.ProvinceDao;
import com.ajax.template.JdbcTemplate;
import com.ajax.template.interf.SqlQuerier;
import com.ajax.util.JdbcUtil;
import com.ajax.vo.Province;

public class ProvinceDaoImpl implements ProvinceDao {

	@Override
	public List<Province> getAllProvinces() {
		JdbcTemplate<List<Province>> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<List<Province>>() {
			
			@Override
			public List<Province> execute(Connection con) throws SQLException {
				String sql = "select * from province";
				PreparedStatement pst = null;
				ResultSet rs = null;
				List<Province> provinces = null;
				try {
					pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
					// ���Ԥ�����������ܹ�����������ִ��, ���ʼ��"ʡ���б�"����
					provinces = new ArrayList<>();
					while(rs.next()) {
						// ��װ���һ��ʡ�ݶ���
						Province province = new Province();
						province.setId(rs.getInt("id"));
						province.setCode(rs.getString("code"));
						province.setName(rs.getString("name"));
						
						// �ѷ�װ�õ�ʡ�ݶ�����ӽ����Ҫ���ص��б������
						provinces.add(province);
					}
				} finally {
					JdbcUtil.close(rs, pst, null);
				}
				return provinces;
			}
		});
	}

	@Override
	public Integer getTotal() {
		JdbcTemplate<Integer> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<Integer>() {
			
			@Override
			public Integer execute(Connection con) throws SQLException {
				Integer count = 0;
				String sql = "select count(*) from province";
				PreparedStatement pst = null;
				ResultSet rs = null;
				try {
					pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						count = rs.getInt(1);
					}
				} finally {
					JdbcUtil.close(rs, pst, null);
				}
				return count;
			}
		});
	}

	@Override
	public List<Province> getProvinceByPage(Integer currentPage, Integer pageCount) {
		JdbcTemplate<List<Province>> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<List<Province>>() {
			
			@Override
			public List<Province> execute(Connection con) throws SQLException {
				String sql = "select * from ("
						+ "select inner_.*, rownum row_ from ("
						+ "select * from province) inner_ "
						+ "where rownum <= " + currentPage * pageCount + ") outter_ "
						+ "where outter_.row_ > " + (currentPage - 1) * pageCount;
				PreparedStatement pst = null;
				ResultSet rs = null;
				List<Province> provinces = null;
				try {
					pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
					// ���Ԥ�����������ܹ�����������ִ��, ���ʼ��"ʡ���б�"����
					provinces = new ArrayList<>();
					while(rs.next()) {
						// ��װ���һ��ʡ�ݶ���
						Province province = new Province();
						province.setId(rs.getInt("id"));
						province.setCode(rs.getString("code"));
						province.setName(rs.getString("name"));
						
						// �ѷ�װ�õ�ʡ�ݶ�����ӽ����Ҫ���ص��б������
						provinces.add(province);
					}
				} finally {
					JdbcUtil.close(rs, pst, null);
				}
				return provinces;
			}
		});
	}

}
