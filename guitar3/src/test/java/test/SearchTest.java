package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import cumt.maokailu.entity.Builder;
import cumt.maokailu.entity.Guitar;
import cumt.maokailu.entity.GuitarSpec;
import cumt.maokailu.entity.Inventory;
import cumt.maokailu.entity.Type;
import cumt.maokailu.entity.Wood;
import cumt.maokailu.service.GuitarSearchService;
import cumt.maokailu.service.impl.GuitarSearchServiceImpl;

public class SearchTest {

	@Test
	public void test() throws SQLException {
		//≤È—Ø
		GuitarSpec guitarSpecInitial=new GuitarSpec(Builder.GISBON ,"model1",Type.ELECTRIC,Wood.MAPLE,Wood.NATO);
		Inventory inventory=new Inventory();
		inventory.addGuitar("4",6666,guitarSpecInitial);
		GuitarSpec guitarSpec= new GuitarSpec (Builder.GISBON ,"model1",Type.ELECTRIC,Wood.MAPLE,Wood.NATO);
		List<Guitar> matchingGuitars =inventory.search(guitarSpec);
		
		if(!matchingGuitars.isEmpty()){
			System.out.println("Hello,you might like those guitars");
			for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
			      Guitar guitar = (Guitar)i.next();
			      GuitarSpec spec=guitar.getSpec();
			      System.out.println(" "+guitar.getSerialNumber()+" "+guitar.getPrice()+" "+spec.getBuilder()+" "+spec.getModel()+" "+spec.getType()+" "+spec.getBackWood()+" "+spec.getTopWood());
			}
		}else{
			 System.out.println("wrong");
		 }
	}

}
