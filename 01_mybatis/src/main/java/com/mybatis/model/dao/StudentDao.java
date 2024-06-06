package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dto.Student;

public class StudentDao {
	
	// DAO에서 SQL문을 실행할 때는 Mybatis가 제공하는 SqlSession 클래스의 메소드를 이용(호출)한다.
	// → 메소드 종류 ? insert, delete, update, selectOne, selectList
	public int insertStudent(SqlSession session) {
		// session.insert의 첫 번째 매개변수 statement ? 
		// → 어떠한 mapper.xml인지 & 어떠한 SQL문인지에 대한 설정(mapper.xml와 sql문에 대한 정보에 대한 설명)
		// → 작성법 : "mapper.xml의 namespace 속성값.sql태그의 id"
		// session.insert의 두 번째 매개변수 ? Object parameter 
		// → 넣을 값들로 주로 Map으로 전달하거나 DTO 객체를 전달하여 SQL문의 매개변수를 전달한다.
		// → MyBatis 입장에서 몇 개의 Parameter가 필요한지 모르기 때문에 Object로 두 번째 매개변수를 1개만 받기 때문이다
		int result = session.insert("student.insertStudent");
		return result;
		
	}
	
	public int insertStudentByName(SqlSession session, String name) {
		// 두 번째 매개변수가 있는 insert문 예시
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
	// 1) selectOne() : 결과(row 수)가 0개 ~ 1개일 경우에 사용하는 메소드 → 지정된 타입(대부분 기본자료형 or DTO 객체)을 반환 
	// 2) selectList() : 결과(row 수)가 다수일 경우에 사용하는 메소드 → List를 반환
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	public Student selectStudentByNo(SqlSession session, int no) {
		return session.selectOne("student.selectStudentByNo", no);
	}
	
	// 학생 전체 조회
	public List<Student> selectStudentAll(SqlSession session){
		// selectList는 3가지의 매개변수까지 받을 수 있다.(statement, object, RowBound)
		// → 원하는 갯수의 row만큼 가져올 수 있는 범위를 설정해줄 수 있다. 
		// selectList의 반환형은 List<E>이다. 따라서, mapper.xml에서 해당 Elements에 대한 선언을 토대로
		// 반환형을 결정해줄 수 있다.
		return session.selectList("student.selectStudentAll");
	}
	
	public List<Student> searchStudentByName(SqlSession session, String name){
		return session.selectList("student.searchStudentByName", "%"+name+"%");
	}
	
	public Map<String, Object> selectStudentByNameMap(SqlSession session, int no){
		return session.selectOne("student.selectStudentByNameMap",no);
	}
	public List<Map<String, Object>> selectAllByMap(SqlSession session){
		return session.selectList("student.selectAllByMap");
	}
	
	// 전체 학생 조회 + 페이징 처리
	public List<Student> selectStudentPaging(SqlSession session, Map<String, Integer> page){
		// MyBatis가 제공하는 Paging 처리 객체를 이용하여 Paging 처리를 할 수 있다.
		// → RowBounds 클래스의 객체 이용
		//	 : 매개변수 있는 생성자를 이용하여 생성한 후 selectList 메소드의 매개변수로 전달한다.
		//	 : RowBounds 클래스 생성자의 매개변수 ? 
		//     ① row 시작 위치를 지정하는 값(offset) → (cPage-1)*numPerpage
		// 	   ② 시작과 끝의 간격(numPerpage) → numPerpage
		RowBounds rb = new RowBounds((page.get("cPage")-1)*page.get("numPerpage"), page.get("numPerpage"));
		// 현재 page의 Map의 Generic 타입으로 String, Integer이기 때문에 RowBounds의 값들의 형변환을 하지 않은 것
		// 만약, 전체 회원 조회가 아니라 특정 조건에 따라 조회를 한다거나 그 외의 매개변수를 전달해줘야 할 경우에는
		// Map<String, Object> 이기 때문에 형변환을 해줘서 RowBounds의 매개변수를 계산해줘야한다.
		
		return session.selectList("student.selectStudentPaging",null,rb);
		// Paging 처리에 사용되는 RowBounds 객체는 3번째 매개변수이다! 
		// 따라서, 2번째 매개변수(쿼리문을 작성할 때 필요한 데이터)가 필요 없다면 아무 값이나 넣어주면된다.
	}
}
