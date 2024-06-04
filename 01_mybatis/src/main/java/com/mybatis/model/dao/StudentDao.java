package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dto.Student;

public class StudentDao {
	
	// dao에서 SQL문을 실행할 때는 Mybatis가 제공하는 SqlSession의 메소드를 이용한다.
	// → insert, delete, update, selectOne, selectList
	public int insertStudent(SqlSession session) {
		
		// session.insert의 매개변수 statement ? mapper.xml와 sql문에 대한 정보에 대한 설명
		// 작성법 : "mapper-namespace 속성값.sql태그의 id"
		// session.insert의 두번 째 매개변수 ? Object parameter → 넣을 값들로 주로 Map으로 전달하고 가져오고 한다.
		int result = session.insert("student.insertStudent");
		return result;
		
	}
	
	public int insertStudentByName(SqlSession session, String name) {
		int result = session.insert("student.insertStudentByName", name);
		return result;
	}
	
	public int insertStudentByMap(SqlSession session, Map map) {
		int result = session.insert("student.insertStudentByMap", map);
		return result;
	}
	
	public int insertStudentAll(SqlSession session, Student s) {
		return session.insert("student.insertStudentAll", s);
	}
	
	public int updateStudentAll(SqlSession session, Student s) {
		return session.update("student.updateStudentAll", s);
	}
	public int deleteStudentAll(SqlSession session, Student s) {
		return session.update("student.deleteStudentAll", s);
	}
	
	// 조회문을 실행할 때 사용하는 메소드
	// 1) selectOne() : 결과(row 수)가 0개 ~ 1개일 경우에 사용하는 메소드 → 지정된 타입을 반환 
	// 2) selectList() : 결과(row 수)가 다수일 경우에 사용하는 메소드 → List를 반환
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	public Student selectStudentByNo(SqlSession session, int no) {
		return session.selectOne("student.selectStudentByNo", no);
	}
}
