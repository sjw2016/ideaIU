package cn.dao;

import java.sql.*;

public class BaseDao {
    private String dir = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/jishi";
    private String name = "root";
    private String key = "root";
    private static Connection conn = null;

    private BaseDao(){
        try {
            Class.forName(dir);
            conn = DriverManager.getConnection(url, name, key);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        if(conn == null){
            new BaseDao();
        }
        return conn;
    }

    public static void getAll(ResultSet rs, Statement st){

            try {
                if(rs != null){
                rs.close();
                }
                if(st != null){
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

