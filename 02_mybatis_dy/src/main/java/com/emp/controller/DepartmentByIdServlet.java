package com.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.dto.Department;
import com.emp.model.service.EmpService;
import com.emp.model.service.EmpServiceImpl;

/**
 * Servlet implementation class DepartmentByIdServlet
 */
@WebServlet("/dept/deptbyid.do")
public class DepartmentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DepartmentByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service = new EmpServiceImpl();
		Department dept = service.selectDeptByDeptId(request.getParameter("deptId"));
		System.out.println(dept);
		dept.getEmployees().forEach(System.out::println);	
		// Employee 클래스나 Department 클래스에서 ToString(exclude={해당 필드})를 해야 StackOverFlow Exception 처리 가능
		// 위의 처리를 하지 않을 경우 Department 필드를 출력할 때 Employee를 출력해야하는데 Employee 클래스에서도 Department를 출력하는 로직을 구성하게됨
		System.out.println(dept.getEmployees().size());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
