package com.github.mahui53541.scsms.service;

import java.util.ArrayList;

import com.github.mahui53541.scsms.domain.Professor;

public interface ProfessorService {
	
	/**
	 * 添加教师
	 * @param professor
	 * @return
	 */
	boolean addProfessor(Professor professor);
	/**
	 * 查询教师
	 * @return
	 */
	ArrayList<Professor> queryProfessor();
	/**
	 * 删除教师
	 * @param ssn
	 * @return
	 */
	boolean deleteProfessor(String ssn);
	/**
	 * 修改教师资料
	 * @param professor
	 * @return
	 */
	boolean updateProfessor(Professor professor);
	

}
