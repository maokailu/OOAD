package cumt.maokailu.dbUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
	 private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	 public static Connection getSqliteConnection(){
			String driver="org.sqlite.JDBC";
			String conStr="jdbc:sqlite:db/guitar.db3";
			Connection conn=null;
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(conStr);
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;			
		}
		public static Connection getMysqlConnection(){
			String driver="com.mysql.jdbc.Driver";
			String conStr="jdbc:mysql://localhost:3306/guitar?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false";
			Connection conn=null;
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(conStr);
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;			
		}

}
