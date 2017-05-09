package dbUtil;


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
	 public static ResultSet executeQuery(String sql,Object[] args){
		 Connection conn=null;
		 PreparedStatement pst=null;
		 ResultSet rs=null;
		 try{
			 Class.forName("org.sqlite.JDBC"); 
			 conn=DriverManager.getConnection("jdbc:sqlite:db/guitar.db3");
			 pst=conn.prepareStatement(sql);
			 if(args!=null&&args.length>0){
				 for(int i=0;i<args.length;i++){
					 pst.setObject(i+1, args[i]);
				 }
			 }
			 rs=pst.executeQuery();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return rs;
	 }

}
