package cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static  Connection getconn(){
			if(conn == null)
				new BaseDao();
			return conn;
		}
		
		public static void closeAll(ResultSet rs, Statement st){
				try {
					if(rs != null)
					rs.close();
					if(st != null)
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
}
