package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dto.Department;
import com.emp.model.dto.Employee;

public class EmpDaoImpl implements EmpDao {
	
	@Override
	public List<Employee> selectEmployeeAll(SqlSession session) {
		return session.selectList("emp.selectEmpAll");
		// Mapped Statements collection does not contain value for emp.selectEmpAll 이라는 에러메세지가 출력될 경우?
		// → mapper.xml의 id에 selectEmpAll이라는 SQL문이 없다는 뜻으로 mapper의 id와 해당 SQL문이 있는지 확인해볼 것
	}

	@Override
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.searchEmp", param);
	}

	@Override
	public Department selectDeptById(SqlSession session, String deptId) {
		return session.selectOne("emp.selectDeptById", deptId);
	}
	
	
}
