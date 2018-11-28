package cn.dao.impl;

import cn.dao.BaseDao;
import cn.dao.peoinfoDao;
import cn.pojo.peoinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Daoimpl implements peoinfoDao {

    @Override
    public peoinfo selAll(String name) {
        Connection conn = BaseDao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        peoinfo p = null;
        String sql = "select id,username,password from peoinfo where username=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new peoinfo();
                p.setId(rs.getInt("id"));
                p.setPassword(rs.getString("password"));
                p.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public int zsg(String sql, Object[] obj) {
        Connection conn = BaseDao.getConn();
        PreparedStatement ps = null;
        int count = 0;
            try {
                ps = conn.prepareStatement(sql);
                if(obj != null){


                    for(int i = 0;i <obj.length;i++) {
                        ps.setObject(i + 1, obj[i]);
                    }
                }
                count = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.getAll(null,ps);
            }
        return count;
    }
}
