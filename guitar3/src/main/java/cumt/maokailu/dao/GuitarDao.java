package cumt.maokailu.dao;

import java.sql.SQLException;
import java.util.List;

import cumt.maokailu.entity.Guitar;

public interface GuitarDao {
	List<Guitar> getAllGuitars() throws SQLException;
	public void addGuitar(Guitar guitar) throws SQLException;
	public void deleteGuitar(String serialNumber ) throws SQLException;
}
