package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dto.Department;
import com.emp.model.dto.Employee;

public interface EmpDao {
	// 인터페이스를 선언함으로써 Service에서 DAO를 호출 할 때 결합도를 낮춰줌
	// → 1. 구현체가 없더라도 compile 시점의 error 발생 X
	// 		= 인터페이스의 구현체를 가상으로 넣어놓고 단일 서비스가 실행되는지 확인 가능(단위테스트 가능)
	//   2. 추후 유지 및 보수에서 이점이 생김
	List<Employee> selectEmployeeAll(SqlSession session);
	List<Employee> searchEmp(SqlSession session, Map<String, Object> param);
	// Depertment를 반환하는 메소드로 deptId를 입력받아서 해당 부서의 사원들까지 전부 출력해주기 위한 메소드로 구상
	// → SELECT * FROM DEPARTMENT LEFT JOIN EMPLOYEE ON DEPT_ID = DEPT_CODE WHERE DEPT_ID=#{deptId}
	// 의 쿼리문을 실행하는 추상메소드로 Department 객체에는 List<Employee>가 필드로 있다. 즉, 검색하는 Id의 Department에
	// 근속 중인 사원들을 조회하는 의미의 쿼리문이 됨
	Department selectDeptById(SqlSession session, String deptId);
}
