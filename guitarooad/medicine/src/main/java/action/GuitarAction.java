package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.GuitarSearchDao;
import dao.GuitarSearchDaoImpl;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Inventory;
import entity.Type;
import entity.Builder;
import entity.Wood;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.GuitarSearchService;
import service.impl.GuitarSearchServiceImpl;

public class GuitarAction extends ActionSupport{
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
	//输出指定字段
	public PrintWriter out()throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out= response.getWriter();
        return out;
	}
	//查询吉他
	public String search() throws IOException{
		out();
		//调用Service层代码
		GuitarSearchService guitarSearchService=new GuitarSearchServiceImpl();
		GuitarSearchDao guitarDao=new GuitarSearchDaoImpl();
		guitarSearchService.setGuitarSearchDao(guitarDao);
		//获取所有的吉他
		Inventory inventory=new Inventory(guitarSearchService.getAllGuitars());
		GuitarSpec guitarSpec=new GuitarSpec(builder,model,type,backWood,topWood);
		List<Guitar> macthingGuitars=inventory.search(guitarSpec);
		JSONArray array=new JSONArray();
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
		return SUCCESS;
	}
	
}
