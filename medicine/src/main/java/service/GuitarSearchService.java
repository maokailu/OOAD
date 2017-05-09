package service;

import java.util.List;

import dao.GuitarSearchDao;
import entity.Guitar;

public interface GuitarSearchService {
	public void setGuitarSearchDao(GuitarSearchDao guitarSearchDao);
	//按条件查询相应吉他
	public List<Guitar> getGuitars(String p);
}
