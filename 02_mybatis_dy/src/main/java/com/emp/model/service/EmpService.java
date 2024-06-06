package com.emp.model.service;

import java.util.List;
import java.util.Map;

import com.emp.model.dto.Employee;

public interface EmpService {
	List<Employee> selectEmployeeAll();
	Employee selectEmployeeByEmpId(int empId);
	List<Employee> searchEmp(Map<String,Object> param);
}
