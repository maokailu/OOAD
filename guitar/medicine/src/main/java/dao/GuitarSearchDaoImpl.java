package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtil.DbUtil;
import entity.Guitar;

public class GuitarSearchDaoImpl implements GuitarSearchDao{

	@Override
	public List<Guitar> getGuitars(String p){
		ResultSet rs=null;
		if (p!= null){		
		    rs=DbUtil.executeQuery("select * from guitar where guitarName like ? or guitarPrice = ? or guitarType like ?", new Object[]{p+"%",p,p+"%"});
		}else{
			rs=DbUtil.executeQuery("select * from guitar", new Object[]{});
		}
		List<Guitar> guitars=new ArrayList<Guitar>();
		try{
			while(rs.next()){
				Guitar guitar = new Guitar();
				guitar.setGuitarId(rs.getString(1));
				guitar.setGuitarName(rs.getString(2));
				guitar.setGuitarType(rs.getString(3));
				guitar.setGuitarPrice(rs.getString(4));
				guitars.add(guitar);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitars;
	}


}
