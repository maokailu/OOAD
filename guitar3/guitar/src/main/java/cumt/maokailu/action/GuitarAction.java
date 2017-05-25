package cumt.maokailu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cumt.maokailu.entity.Builder;
import cumt.maokailu.entity.Guitar;
import cumt.maokailu.entity.GuitarSpec;
import cumt.maokailu.entity.Inventory;
import cumt.maokailu.entity.Type;
import cumt.maokailu.entity.Wood;
import cumt.maokailu.service.GuitarSearchService;
import cumt.maokailu.service.impl.GuitarSearchServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serialNumber;
	private double price;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	//前台传入的search参数
	private Builder builder; 
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	public Builder getBuilder() {
		return builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Wood getBackWood() {
		return backWood;
	}
	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}
	public Wood getTopWood() {
		return topWood;
	}
	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}
	GuitarSearchService guitarSearchService=new GuitarSearchServiceImpl();
	//查询吉他
	public String search() throws IOException, SQLException {
		JSONArray array=new JSONArray();
		Inventory inventory= guitarSearchService.getInventory();
		@SuppressWarnings("unchecked")
		List<Guitar> macthingGuitars=inventory.search(new GuitarSpec(builder,model,type,backWood,topWood));
		for(Guitar g:macthingGuitars){
			 JSONObject jo=new JSONObject();
			 //字符型
			 jo.put("serialNumber",g.getSerialNumber());
			 jo.put("price",g.getPrice());
			 jo.put("builder",g.getSpec().getBuilder());
			 jo.put("model",g.getSpec().getModel());
			 jo.put("type",g.getSpec().getType());
			 jo.put("backWood",g.getSpec().getBackWood());
			 jo.put("topWood",g.getSpec().getTopWood());
			 array.add(jo);
		}		
		out().print(array);
		out().flush(); 
		out().close();
		return null;
	}
	public PrintWriter out()throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out= response.getWriter();
        return out;
	}
	//增加
	public String add() throws IOException{
		out();
		String message="";
		try{
			Guitar guitar=new Guitar(serialNumber,price,new GuitarSpec(builder,model,type,backWood,topWood));
			guitarSearchService.addGuitar(guitar);
			message="添加吉他成功";
		}
		catch(Exception e){
			message="添加吉他失败";
		}
		out().print(message);
	    out().flush(); 
	    out().close();      
		return null;
	}
	//删除
	public String delete() throws IOException, SQLException{
		out();
		guitarSearchService.deleteGuitar(serialNumber);
		String message="删除成功";
		out().print(message);
		out().flush(); 
		out().close();
		return null;
		
	}
}
