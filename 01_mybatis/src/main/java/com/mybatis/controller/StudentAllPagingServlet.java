package com.mybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.dto.Student;
import com.mybatis.model.service.StudentService;

/**
 * Servlet implementation class StudentAllPagingServlet
 */
@WebServlet("/student/studentpage.do")
public class StudentAllPagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAllPagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage=1;
		int numPerpage=5;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {}
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		} catch(NumberFormatException e) {}
		Map<String, Integer> page = Map.of("cPage", cPage, "numPerpage", numPerpage);
		List<Student> students = new StudentService().selectStudentPaging(page);
		
		students.forEach(System.out::println);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
