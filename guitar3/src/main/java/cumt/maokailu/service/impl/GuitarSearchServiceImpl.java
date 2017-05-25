package cumt.maokailu.service.impl;

import java.sql.SQLException;
import java.util.List;

import cumt.maokailu.dao.DataAccess;
import cumt.maokailu.dao.GuitarDao;
import cumt.maokailu.entity.Guitar;
import cumt.maokailu.entity.Inventory;
import cumt.maokailu.service.GuitarSearchService;

public class GuitarSearchServiceImpl implements GuitarSearchService{
	GuitarDao guitarDao=DataAccess.CreateGuitarDao();
	//给Inventory加载所有吉他
	public Inventory getInventory() throws SQLException { 
		Inventory inventory=new Inventory();
		List<Guitar> list=guitarDao.getAllGuitars();
		for(Guitar g:list){
			inventory.addGuitar(g.getSerialNumber(),g.getPrice(),g.getSpec());
		}
		return inventory;
	}
	 public void addGuitar(Guitar guitar) throws SQLException {
		 guitarDao.addGuitar(guitar);
	 }
	 
	 public void deleteGuitar(String serialNumber ) throws SQLException{
		 guitarDao.deleteGuitar(serialNumber );
	 }
}
