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
import entity.Medicines;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.GuitarSearchService;
import service.impl.GuitarSearchServiceImpl;

public class GuitarAction extends ActionSupport{
	private String p;
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	//���ָ���ֶ�
	public PrintWriter out()throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out= response.getWriter();
        return out;
	}
	//��ѯ����
	public String search() throws IOException{
		out();
		//����Service�����
		GuitarSearchService guitarSearchService=new GuitarSearchServiceImpl();
		GuitarSearchDao guitarDao=new GuitarSearchDaoImpl();
		guitarSearchService.setGuitarSearchDao(guitarDao);
		List<Guitar> guitars = guitarSearchService.getGuitars(p);
		JSONArray array=new JSONArray();
		for(Guitar g:guitars){
			 JSONObject jo=new JSONObject();
			 //�ַ���
			 jo.put("guitarId",g.getGuitarId());
			 jo.put("guitarName",g.getGuitarName());
			 jo.put("guitarType",g.getGuitarType());
			 jo.put("guitarPrice",g.getGuitarPrice());
			 array.add(jo);
		}
		out().print(array);
		out().flush(); 
		out().close();
		return SUCCESS;
	}
	
}
