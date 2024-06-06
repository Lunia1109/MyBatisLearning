package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dto.Employee;

public interface EmpDao {
	List<Employee> selectEmployeeAll(SqlSession session);
	List<Employee> searchEmp(SqlSession session, Map<String, Object> param);
}
