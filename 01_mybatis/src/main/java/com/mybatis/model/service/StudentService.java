package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
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
	// 오버로딩
	public int insertStudent(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentByName(session, name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentByMap(Map map) {
		SqlSession session = getSession();
		int result = dao.insertStudentByMap(session, map);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudentAll(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int updateStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudentAll(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int deleteStudentAll(Student s) {
		SqlSession session = getSession();
		int result = dao.deleteStudentAll(session, s);
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
	
	public List<Student> selectStudentAll(){
		SqlSession session = getSession();
		List<Student> result = dao.selectStudentAll(session);
		session.close();
		return result;
	}
	
	public List<Student> searchStudentByName(String name){
		SqlSession session = getSession();
		List<Student> result = dao.searchStudentByName(session, name);
		session.close();
		return result;
	}
	// DTO 만들지 않고 Map으로 가져오기
	public Map<String, Object> selectStudentByNameMap(int no) {
		SqlSession session = getSession();
		Map<String, Object> student = dao.selectStudentByNameMap(session, no);
		session.close();
		return student;
	}
	
	public List<Map<String,Object>> selectAllByMap(){
		SqlSession session = getSession();
		List<Map<String,Object>> students = dao.selectAllByMap(session);
		session.close();
		return students;
	}
	
	// 페이징 처리
	public List<Student> selectStudentPaging(Map<String, Integer> page){
		SqlSession session = getSession();
		List<Student> result = dao.selectStudentPaging(session, page);
		session.close();
		return result;
	}
	
}
