package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtil.DbUtil;
import entity.Builder;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Type;
import entity.Wood;

public class GuitarSearchDaoImpl implements GuitarSearchDao{

	@Override
	public List<Guitar> getAllGuitars() {
		ResultSet rs=DbUtil.executeQuery("select * from guitar", new Object[]{});
		List<Guitar> guitars=new ArrayList<Guitar>();
		try{
			while(rs.next()){
				GuitarSpec guitarSpec=new GuitarSpec(Builder.valueOf(rs.getString(3)),rs.getString(4),Type.valueOf(rs.getString(5)),Wood.valueOf(rs.getString(6)),Wood.valueOf(rs.getString(7)));
				Guitar guitar = new Guitar(rs.getString(1),rs.getDouble(2),guitarSpec);
				guitars.add(guitar);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitars;
	}


}
