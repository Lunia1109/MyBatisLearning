package com.emp.model.service;

import static com.emp.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dao.EmpDao;
import com.emp.model.dao.EmpDaoImpl;
import com.emp.model.dto.Department;
import com.emp.model.dto.Employee;

public class EmpServiceImpl implements EmpService {
	// 가상의 DAO 구현체 설정
	private EmpDao dao=new EmpDaoImpl();
	
	@Override
	public List<Employee> selectEmployeeAll() {
		SqlSession session=getSession();
		List<Employee> result=dao.selectEmployeeAll(session);
		session.close();
		return result;
	}

	@Override
	public Employee selectEmployeeByEmpId(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchEmp(Map<String, Object> param) {
		SqlSession session = getSession();
		List<Employee> result = dao.searchEmp(session, param);
		session.close();
		return result;
	}

	@Override
	public Department selectDeptByDeptId(String deptId) {
		SqlSession session = getSession();
		Department dept = dao.selectDeptById(session, deptId);
		session.close();
		return dept;
	}
	
	
	
	
}
