package com.mybatis.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.dto.Student;
import com.mybatis.model.service.StudentService;

/**
 * Servlet implementation class InsertStudentByMap
 */
@WebServlet("/insertstudentbymap.do")
public class InsertStudentByMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentByMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 내 풀이 → Map 이용
		/*
		  String name = request.getParameter("name"); 
		  String studentTel = request.getParameter("studentTel"); 
		  String studentEmail =  request.getParameter("studentEmail"); 
		  String studentAddr = request.getParameter("studentAddr"); 
		  Map<String, String> map; 
		  map = Map.of("name", name, "tel", studentTel, "email", studentEmail, "addr", studentAddr); 
		  int result = new StudentService().insertStudentByMap(map);
		 */
		Student s = Student.builder().studentName(request.getParameter("name")).studentTel(request.getParameter("studentTel")).studentEmail(getServletInfo())
									 .studentAddr(request.getParameter("studentAddr")).build();
		
		int result = new StudentService().insertStudentAll(s);
		response.getWriter().write(result>0?"success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
