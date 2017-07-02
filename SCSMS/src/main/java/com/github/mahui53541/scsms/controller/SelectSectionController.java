package com.github.mahui53541.scsms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.github.mahui53541.scsms.domain.Student;
import com.github.mahui53541.scsms.service.LoginService;
import com.github.mahui53541.scsms.service.SectionService;
import com.github.mahui53541.scsms.service.SelectSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 选课流程
 * @author Administrator
 *
 */
@Controller
public class SelectSectionController {
	private Student student;
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	@Autowired
	@Qualifier("sectionService")
	private SectionService sectionService;
	@Autowired
	private SelectSectionService selectSectionService;
	@RequestMapping(value="/studentLogin")
	public ModelAndView login(String ssn,String password,
			 ModelAndView mv,
			 HttpSession session){
		student = loginService.studentLogin(ssn,password);
		if(student != null){
			session.setAttribute("student", student);
			mv.setViewName("main");
		}else{
			mv.addObject("message", "登录名或密码错误，请重新输入");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	/**
	 * 选课之前查询课程安排
	 * @return
	 */
	@RequestMapping(value="querySection")
	@ResponseBody
	public Object querySection(){
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list=sectionService.querySection();
		return list;
	}
	/**
	 * 学生选课
	 * @param sectionNo
	 * @return
	 */
	@RequestMapping(value="selectSection",produces="text/html;charset=UTF-8")
	@ResponseBody  	  
	public Object selectSection(int sectionNo,HttpSession session){
		/*String ssn=student.getSsn();*/
		/*String ssn="09143604";*/
		Student student=(Student)session.getAttribute("student");
		String ssn=student.getSsn();
		String result=selectSectionService.selectSection(ssn,sectionNo);
		return result;
	}
	/**
	 * 查看某门课有哪些学生选了
	 */
	@RequestMapping(value="queryEnrolledStudents")
	@ResponseBody
	public Object queryEnrolledStudents(int sectionNo){
		/*int sectionNo=2;*/
		ArrayList<Student> enrolledStudents=new ArrayList<Student> ();
		enrolledStudents=selectSectionService.queryEnrolledStudents(sectionNo);
		return enrolledStudents;
	}
	
	
}
