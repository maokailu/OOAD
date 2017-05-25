package cumt.maokailu.service;

import java.sql.SQLException;

import cumt.maokailu.entity.Guitar;
import cumt.maokailu.entity.Inventory;

public interface GuitarSearchService {
	public Inventory getInventory() throws SQLException;
	public void addGuitar(Guitar guitar) throws SQLException;
	public void deleteGuitar(String serialNumber) throws SQLException;
}
