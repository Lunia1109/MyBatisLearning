package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.dto.Student;

public class StudentService {
	private StudentDao dao = new StudentDao();
	
	
	public int insertStudent() {
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudent(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentByName(session, name);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentByMap(Map map) {
		SqlSession session = getSession();
		int result = dao.insertStudentByMap(session, map);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudentAll(session, s);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int updateStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudentAll(session, s);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int deleteStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.deleteStudentAll(session, s);
		// 트랜젝션 처리
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int selectStudentCount() {
		SqlSession session = getSession();
		int count = dao.selectStudentCount(session);
		session.close();
		return count;
	}
	
	public Student selectStudentByNo(int no) {
		SqlSession session = getSession();
		Student s = dao.selectStudentByNo(session, no);
		session.close();
		return s;
	}
}
