package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dto.Employee;

public class EmpDaoImpl implements EmpDao {
	
	@Override
	public List<Employee> selectEmployeeAll(SqlSession session) {
		return session.selectList("emp.selectEmpAll");
	}

	@Override
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.searchEmp", param);
	}

}
