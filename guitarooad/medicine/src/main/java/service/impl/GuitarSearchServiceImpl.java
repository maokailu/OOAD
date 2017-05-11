package service.impl;

import java.util.List;

import dao.GuitarSearchDao;
import entity.Guitar;
import service.GuitarSearchService;

public class GuitarSearchServiceImpl implements GuitarSearchService{
	private GuitarSearchDao guitarSearchDao;
	public void setGuitarSearchDao(GuitarSearchDao guitarSearchDao) {
		this.guitarSearchDao =guitarSearchDao;
	}
	@Override
	public List<Guitar> getAllGuitars() {
		return guitarSearchDao.getAllGuitars();
	}

}
