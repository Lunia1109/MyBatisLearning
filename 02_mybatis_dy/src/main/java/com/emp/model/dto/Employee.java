package com.emp.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude= {"dept"})	// dept 항목에 대해서는 ToString()을 override 할 경우 제외하라는 의미
public class Employee {
	private int empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	// private String deptCode; 현재의 이 컬럼은 DB입장의 설계
	private Department dept;	
	// 이와 같이 Class와 Class간의 관계를 가질 때는 mapper은 resultMap으로 결과를 처리함
	// 더불어 1:1 관계일 때에는 association 태그를 사용하여 has a 관계를 표시함
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private String managerId;
	private Date hireDate;
	private Date entDate;
	private String gender;
	// Data를 가지고 올 때 entYn(퇴사여부)에 대해서는 DB쪽에서 filter하는 용도이기 때문에
	// 대부분 DTO 객체에 선언해서 같이 가져오지는 않는다.
}
