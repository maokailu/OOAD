package dao;

import java.util.List;

import entity.Guitar;

public interface GuitarSearchDao {

	List<Guitar> getGuitars(String p);

}
