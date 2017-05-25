package test;

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

public class SearchTest {

	@Test
	public void test() {
		
		GuitarSpec guitarSpecInitial=new GuitarSpec(Builder.FENDER ,"model1",Type.ACOUSTIC,Wood.NATO,Wood.NATO);
		Guitar guitarInitial=new Guitar("1",6,guitarSpecInitial);
		
		List<Guitar> guitars = new ArrayList<Guitar>();
		guitars.add(guitarInitial);
		
		Inventory inventory=new Inventory();
		
		GuitarSpec guitarSpec= new GuitarSpec (Builder.FENDER ,"model1",Type.ACOUSTIC,Wood.NATO,Wood.NATO);
		
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
