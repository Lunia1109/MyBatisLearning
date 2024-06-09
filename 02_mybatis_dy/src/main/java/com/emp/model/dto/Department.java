package com.emp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
	private String deptId;
	private String deptTitle;
	private String locationId;
	// 같은 부서에 근무하는 사원들 ? DB에서는 동일한 SQL문일 수 있다(양방향). but 자바에서는 다르다. 
	// 즉, 클래스 설계 상 객체 간의 의미를 생각해서 방향성을 설정할 수 있다.(1사원 → 1부서(Department), 1부서 → 多사원(List<Employee>)
	// ex. SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;
	// 	   SELECT * FROM DEPARTMENT JOIN EMPLOYEE ON DEPT_ID = DEPT_CODE;
	// 현재 위의 3개의 필드만을 선언했다면, Employee 기준으로 Department를 조회가 할 수 있으나, 
	// 현재로써 Department에서 Employee를 조회할 수 없다.
	// 따라서 해당 기능을 구현하고자 한다면, Department에서도 Employee를 가져오기 위해서는 필드를 선언함으로써 has a 관계를 만들어 줘야한다.
	private List<Employee> employees;
}
