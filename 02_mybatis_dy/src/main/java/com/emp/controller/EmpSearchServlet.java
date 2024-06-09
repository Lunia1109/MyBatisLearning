package com.emp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.dto.Employee;
import com.emp.model.service.EmpService;
import com.emp.model.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpSearchServlet
 */
@WebServlet("/emp/searchEmp.do")
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service = new EmpServiceImpl();
		// get방식의 요청이기 때문에 Encode 타입에 대한 설정 필요 없음
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		// 해당 기능에서 수행할 SQL구문을 항상 먼저 생각하고 로직을 구성하는 습관 가질 것 
		// : SELECT * FROM EMPLOYEE WHERE ${type} LIKE '%'||#{keyword}||'%' → type에 따른 입력한 사원 조회
		
		String gender = request.getParameter("gender");
		
		int salary = 0;
		try{
			salary = Integer.parseInt(request.getParameter("salary"));
		} catch (NumberFormatException e) { }
		String salFlag = request.getParameter("salFlag");
		
		double bonus = -999;
		try {
			bonus = Double.parseDouble(request.getParameter("bonus"))/100;
		}catch(NumberFormatException e) { }
		String bonusFlag = request.getParameter("bonusFlag");
		

		Map<String, Object> param = new HashMap<>();
		// Map.of("type", type, "keyword", keyword)   vs  HashMap의 put
		//	→ Map.of는 크기가 고정(불변)이기 때문에 null값이 들어가면 의미가 없는 데이터가 된다. 
		//    따라서 기본적으로 Map.of 메소드에서는 null 값이 들어가지 못하게 막아놓음(Error 출력)
		param.put("type", type);
		param.put("keyword", keyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salFlag", salFlag);
		param.put("bonusFlag", bonusFlag);
		param.put("bonus", bonus);
		// checkbox 타입의 input 타입 태그는 단일 값이 아니기에 getParameterValues 메소드로 가져오며 return은 String[] 형이다.
		// 따라서 해당 parameter 관련하여 mapper의 SQL문을 구성해본다면 SELECT * FROM EMPLOYEE WHERE JOBCODE IN ('J1', 'J2',...)
		// 의 형태를 가지기 때문에 이를 처리해야하기 위한 생각을 해야한다. → mapper 에서 <foreach> 태그를 이용한다. 
		param.put("jobCodes", request.getParameterValues("jobCode"));
		List<Employee> employee = service.searchEmp(param);	
		// 현재 EmpService 인터페이스에서 searchEmp의 매개변수는 Map으로 선언해놨음
		// → 타입에 따른 사원 조회를 구현하도록 추상적으로 선언해놓은 메소드이기 때문
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/emp/emp.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
