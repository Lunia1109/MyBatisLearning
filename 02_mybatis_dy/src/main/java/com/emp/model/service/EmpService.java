package com.emp.model.service;

import java.util.List;
import java.util.Map;

import com.emp.model.dto.Department;
import com.emp.model.dto.Employee;

public interface EmpService {
	// 인터페이스를 선언함으로써 Controller 에서 Service를 호출 할 때 결합도를 낮춰줌
	// → 1. 구현체가 없더라도 compile 시점의 error 발생 X 
	// 		= 인터페이스의 구현체를 가상으로 넣어놓고 단일 서비스가 실행되는지 확인 가능(단위테스트 가능)
	//   2. 추후 유지 및 보수에서 이점이 생김
	List<Employee> selectEmployeeAll();
	Employee selectEmployeeByEmpId(int empId);
	List<Employee> searchEmp(Map<String,Object> param);
	Department selectDeptByDeptId(String deptId);
}
