package com.emp.controller;

import java.io.IOException;
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
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		// Map.of( )   vs  HashMap의 put
		//	→ Map.of는 크기가 고정이기 때문에 null값이 들어가면 의미가 없는
		//    데이터가 된다. 따라서 기본적으로 null 값이 들어가지 못하게 막아놓음
		
		String gender = request.getParameter("gender");
		
		int salary = 0;
		try{
			salary = Integer.parseInt(request.getParameter("salary"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String salFlag = request.getParameter("salFlag");
		
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salFlag", salFlag);
		List<Employee> employee = service.searchEmp(param);
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
