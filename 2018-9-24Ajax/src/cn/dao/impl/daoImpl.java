package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BaseDao;
import cn.dao.getName;
import cn.pojo.peoinfo;

public class daoImpl implements getName{

	@Override
	public peoinfo getname(String name) {
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		peoinfo p = null;
		String sql = "select username from peoinfo where username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				 p = new peoinfo();
				p.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<peoinfo> getAll() {
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		peoinfo p = null;
		List<peoinfo> list = new ArrayList<peoinfo>();
		String sql = "select * from peoinfo";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				 p = new peoinfo();
				p.setUsername(rs.getString("username"));
				p.setId(rs.getInt("id"));
				p.setPassword(rs.getString("password"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
